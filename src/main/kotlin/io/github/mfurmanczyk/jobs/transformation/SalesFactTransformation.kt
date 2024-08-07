package io.github.mfurmanczyk.jobs.transformation

import io.github.mfurmanczyk.model.*
import io.github.mfurmanczyk.utils.Scripts
import io.github.mfurmanczyk.utils.calculateSaleValue
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.types.DataTypes
import org.jetbrains.kotlinx.spark.api.*

fun main() = withSpark(
    appName = "transformation_fact_sales",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val orderDs = spark.read().parquet("data/intermediate/ext_t_order.parquet").to<Order>()
    val orderRelDs = spark.read().parquet("data/intermediate/ext_t_order_rel.parquet").to<OrderRel>()
    val promoDs = spark.read().parquet("data/intermediate/ext_t_promo.parquet").to<Promo>()
    val promoRelDs = spark.read().parquet("data/intermediate/ext_t_promo_rel.parquet").to<PromoRel>()
    val productDs = spark.read().parquet("data/intermediate/ext_t_product.parquet").to<Product>()
    val customerDs = spark.read().parquet("data/intermediate/ext_t_customer.parquet").to<Customer>()

    val addressDimDf = spark.read().parquet("data/target/t_address_dim.parquet")

    val orderAndProductDf = orderDs
        .join(orderRelDs, orderDs.col("id") eq orderRelDs.col("order_id"))
        .join(productDs, orderRelDs.col("product_id") eq productDs.col("id"))
        .join(customerDs, orderDs("customer_id") eq customerDs("id"))
        .select(
            orderDs("id"),
            orderDs("customer_id"),
            orderDs("timestamp_order").cast(DataTypes.DateType).alias("date_order"),
            orderDs("status_order"),
            orderDs("status_payment"),
            orderRelDs("product_id"),
            orderRelDs("quantity_product"),
            productDs("price"),
            productDs("category_id"),
            customerDs("address_street"),
            customerDs("address_street2"),
            customerDs("address_postal_code")
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
        .join(addressDimDf,
            (orderAndProductDf("address_street") eq addressDimDf("street_1"))
                .and(orderAndProductDf("address_street2") eq addressDimDf("street_2"))
                .and(orderAndProductDf("address_postal_code") eq addressDimDf("postal_code"))
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
            addressDimDf("id").alias("address_id")
        )

    factDf.write().mode(SaveMode.Overwrite).parquet("data/target/t_sales_fact.parquet")

    Scripts.endScript(spark)
}