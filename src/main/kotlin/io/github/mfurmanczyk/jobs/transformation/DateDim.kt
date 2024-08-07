package io.github.mfurmanczyk.jobs.transformation

import io.github.mfurmanczyk.model.Customer
import io.github.mfurmanczyk.model.Order
import io.github.mfurmanczyk.model.Promo
import io.github.mfurmanczyk.utils.Scripts
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.functions.*
import org.apache.spark.sql.types.DataTypes
import org.jetbrains.kotlinx.spark.api.SparkLogLevel
import org.jetbrains.kotlinx.spark.api.col
import org.jetbrains.kotlinx.spark.api.to
import org.jetbrains.kotlinx.spark.api.withSpark

fun main() = withSpark(
    appName = "transformation_dim_date",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val customerDs = spark.read().parquet("data/intermediate/ext_t_customer.parquet").to<Customer>()
        .select(
            "date_birth",
            "date_join"
        )
    val orderDs = spark.read().parquet("data/intermediate/ext_t_order.parquet").to<Order>()
        .select(
            col("timestamp_order").cast(DataTypes.DateType).alias("date_order")
        )

    val promoDs = spark.read().parquet("data/intermediate/ext_t_promo.parquet").to<Promo>()
        .select(
            "date_start",
            "date_end"
        )

    val dateColumnDf = customerDs.select("date_birth")
        .unionAll(customerDs.select("date_join"))
        .unionAll(orderDs)
        .unionAll(promoDs.select("date_start"))
        .unionAll(promoDs.select("date_end"))
        .withColumnRenamed("date_birth", "date")

    val dateDimDf = dateColumnDf
        .withColumns(
            mapOf(
                "day_of_month" to dayofmonth(col("date")),
                "day_of_week" to dayofweek(col("date")),
                "day_of_year" to dayofyear(col("date")),
                "month" to month(col("date")),
                "year" to year(col("date")),
                "quarter" to quarter(col("date")),
                "business_week" to weekofyear(col("date"))
            )
        )
        .dropDuplicates()
        .orderBy(desc("date"))

    dateDimDf.write().mode(SaveMode.Overwrite).parquet("data/target/t_date_dim.parquet")

    Scripts.endScript(spark)
}