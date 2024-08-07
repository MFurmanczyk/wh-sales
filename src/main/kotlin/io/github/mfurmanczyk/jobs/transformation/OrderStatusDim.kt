package io.github.mfurmanczyk.jobs.transformation

import io.github.mfurmanczyk.model.Order
import io.github.mfurmanczyk.utils.Scripts
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.functions.asc
import org.apache.spark.sql.functions.`when`
import org.jetbrains.kotlinx.spark.api.*

fun main() = withSpark(
    appName = "transformation_dim_order_status",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val orderDs = spark.read().parquet("data/intermediate/ext_t_order.parquet").to<Order>()

    /* 1 - received, 2 - in realisation, 3 - sent, 4 - delivered, 5 - returned, 9 - cancelled*/
    val dimDf = orderDs
        .select(
            orderDs("status_order").alias("id"),
            `when`(orderDs("status_order") eq 1, "RECEIVED")
                .`when`(orderDs("status_order") eq 2, "IN_REALISATION")
                .`when`(orderDs("status_order") eq 3, "SENT")
                .`when`(orderDs("status_order") eq 4, "DELIVERED")
                .`when`(orderDs("status_order") eq 5, "RETURNED")
                .`when`(orderDs("status_order") eq 9, "CANCELLED")
                .otherwise("UNDEFINED")
                .alias("status_name") ,
            `when`(orderDs("status_order") eq 1, "REC")
                .`when`(orderDs("status_order") eq 2, "RLS")
                .`when`(orderDs("status_order") eq 3, "SNT")
                .`when`(orderDs("status_order") eq 4, "DLV")
                .`when`(orderDs("status_order") eq 5, "RET")
                .`when`(orderDs("status_order") eq 9, "CAN")
                .otherwise("UDF")
                .alias("status_abbrev")
        )
        .distinct()
        .orderBy(asc("id"))

    dimDf.write().mode(SaveMode.Overwrite).parquet("data/target/t_order_status_dim.parquet")

    Scripts.endScript(spark)
}