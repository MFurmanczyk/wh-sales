package io.github.mfurmanczyk.jobs.transformation

import io.github.mfurmanczyk.model.Customer
import io.github.mfurmanczyk.utils.Scripts
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.functions.monotonically_increasing_id
import org.jetbrains.kotlinx.spark.api.SparkLogLevel
import org.jetbrains.kotlinx.spark.api.invoke
import org.jetbrains.kotlinx.spark.api.to
import org.jetbrains.kotlinx.spark.api.withSpark

fun main() = withSpark(
    appName = "transformation_dim_address",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val customerDs = spark.read().parquet("data/intermediate/ext_t_customer.parquet").to<Customer>()

    val addressDf = customerDs
        .select(
            customerDs("address_street").alias("street_1"),
            customerDs("address_street2").alias("street_2"),
            customerDs("address_city").alias("city"),
            customerDs("address_state").alias("state"),
            customerDs("address_postal_code").alias("postal_code"),
            customerDs("address_country_iso_2").alias("country_code")
        )
        .distinct()


    val dimDf = addressDf
        .withColumn(
            "id",
            monotonically_increasing_id()
        )
        .select(
            "id",
            "street_1",
            "street_2",
            "city",
            "state",
            "postal_code",
            "country_code"
        )

    dimDf.write().mode(SaveMode.Overwrite).parquet("data/target/t_address_dim.parquet")


    Scripts.endScript(spark)
}