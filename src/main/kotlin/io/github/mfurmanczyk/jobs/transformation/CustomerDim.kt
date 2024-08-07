package io.github.mfurmanczyk.jobs.transformation

import io.github.mfurmanczyk.model.Customer
import io.github.mfurmanczyk.utils.Scripts
import org.apache.spark.sql.SaveMode
import org.jetbrains.kotlinx.spark.api.SparkLogLevel
import org.jetbrains.kotlinx.spark.api.to
import org.jetbrains.kotlinx.spark.api.withSpark

fun main() = withSpark(
    appName = "transformation_dim_customer",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val customerDs = spark.read().parquet("data/intermediate/ext_t_customer.parquet").to<Customer>()

    val dimDF = customerDs.select(
        "id",
        "name",
        "name_2",
        "surname",
        "gender",
        "email_address",
        "phone_number",
        "date_birth",
        "date_join"
    )

    dimDF.write().mode(SaveMode.Overwrite).parquet("data/target/t_customer_dim.parquet")

    Scripts.endScript(spark)
}