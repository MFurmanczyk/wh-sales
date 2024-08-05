package io.github.mfurmanczyk.jobs

import io.github.mfurmanczyk.model.*
import io.github.mfurmanczyk.utils.*
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.types.DataTypes
import org.jetbrains.kotlinx.spark.api.*

fun main() = withSpark(
    appName = "transformation_fact_sales",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val orderDs = spark.read().parquet("data/intermediate/ext_t_order.parquet").to<Order>().cache()
    val orderRelDs = spark.read().parquet("data/intermediate/ext_t_order_rel.parquet").to<OrderRel>()
    val promoDs = spark.read().parquet("data/intermediate/ext_t_promo.parquet").to<Promo>()
    val promoRelDs = spark.read().parquet("data/intermediate/ext_t_promo_rel.parquet").to<PromoRel>()
    val productDs = spark.read().parquet("data/intermediate/ext_t_product.parquet").to<Product>()

    val orderAndProductDf = orderDs
        .join(orderRelDs, orderDs.col("id") eq orderRelDs.col("order_id"))
        .join(productDs, orderRelDs.col("product_id") eq productDs.col("id"))
        .select(
            orderDs("id"),
            orderDs("customer_id"),
            orderDs("timestamp_order").cast(DataTypes.DateType).alias("date_order"),
            orderDs("status_order"),
            orderDs("status_payment"),
            orderRelDs("product_id"),
            orderRelDs("quantity_product"),
            productDs("price"),
            productDs("category_id")
        )

    val promoJoinedDf = promoDs
        .join(promoRelDs, promoDs.col("id") eq promoRelDs.col("promo_id"))
        .select(
            promoDs("id").alias("promo_id"),
            promoDs("date_start"),
            promoDs("date_end"),
            promoRelDs("product_id"),
            promoRelDs("category_id"),
            promoRelDs("rate_discount")
        )

    val calculateSaleValue = udf(::calculateSaleValue)

    val factDf = orderAndProductDf
        .join(
            promoJoinedDf,
            ((promoJoinedDf("product_id") eq orderAndProductDf("product_id"))
                .or(promoJoinedDf("category_id") eq orderAndProductDf("category_id")))
                .and(orderAndProductDf("date_order").between(promoDs("date_start"), promoDs("date_end"))),
            "left_outer"
            )
        .withColumn(
            "sale_value",
            calculateSaleValue(
                orderAndProductDf("price"),
                orderAndProductDf("quantity_product"),
                promoJoinedDf("rate_discount")
            )
        )
        .select(
            orderAndProductDf("id").alias("sale_id"),
            orderAndProductDf("customer_id"),
            orderAndProductDf("product_id"),
            promoJoinedDf("promo_id"),
            col("sale_value"),
            orderAndProductDf("date_order").alias("sale_date"),
            orderAndProductDf("status_order").alias("order_status_id"),
            orderAndProductDf("status_payment").alias("payment_status_id"),
        )

    factDf.write().mode(SaveMode.Overwrite).parquet("data/target/t_sales_fact.parquet")

    Scripts.endScript(spark)
}