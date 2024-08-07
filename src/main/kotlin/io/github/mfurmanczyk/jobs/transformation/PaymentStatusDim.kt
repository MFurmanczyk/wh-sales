package io.github.mfurmanczyk.jobs.transformation

import io.github.mfurmanczyk.model.Order
import io.github.mfurmanczyk.utils.Scripts
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.functions.asc
import org.apache.spark.sql.functions.`when`
import org.jetbrains.kotlinx.spark.api.*

fun main() = withSpark(
    appName = "transformation_dim_payment_status",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val orderDs = spark.read().parquet("data/intermediate/ext_t_order.parquet").to<Order>()

    /* 1 - confirmed, 2 - in progress, 3 - to be paid ,9 - rejected*/
    val dimDf = orderDs
        .select(
            orderDs("status_payment").alias("id"),
            `when`(orderDs("status_payment") eq 1, "CONFIRMED")
                .`when`(orderDs("status_payment") eq 2, "IN_PROGRESS")
                .`when`(orderDs("status_payment") eq 3, "TO_BE_PAIN")
                .`when`(orderDs("status_payment") eq 9, "REJECTED")
                .otherwise("UNDEFINED")
                .alias("status_name") ,
            `when`(orderDs("status_payment") eq 1, "CNF")
                .`when`(orderDs("status_payment") eq 2, "PRG")
                .`when`(orderDs("status_payment") eq 3, "TBP")
                .`when`(orderDs("status_payment") eq 9, "REJ")
                .otherwise("UDF")
                .alias("status_abbrev")
        )
        .distinct()
        .orderBy(asc("id"))

    dimDf.write().mode(SaveMode.Overwrite).parquet("data/target/t_payment_status_dim.parquet")

    Scripts.endScript(spark)
}