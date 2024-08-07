package io.github.mfurmanczyk.jobs

import io.github.mfurmanczyk.model.Customer
import org.apache.spark.sql.SaveMode
import org.jetbrains.kotlinx.spark.api.SparkLogLevel
import org.jetbrains.kotlinx.spark.api.to
import org.jetbrains.kotlinx.spark.api.withSpark

fun main() = withSpark(
    appName = "transformation_dim_customer",
    logLevel = SparkLogLevel.INFO
) {

    val customerDs = spark.read().parquet("data/intermediate/ext_t_customer.parquet").to<Customer>()

    val factDf = customerDs.select(
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

    factDf.write().mode(SaveMode.Overwrite).parquet("data/target/t_customer_dim.parquet")
}