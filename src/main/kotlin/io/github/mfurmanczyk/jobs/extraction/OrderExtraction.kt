package io.github.mfurmanczyk.jobs.extraction

import io.github.mfurmanczyk.database.Database
import io.github.mfurmanczyk.database.MySqlDatabase
import io.github.mfurmanczyk.database.configuration.MySqlConfiguration
import io.github.mfurmanczyk.utils.Scripts
import org.apache.spark.sql.SaveMode
import org.jetbrains.kotlinx.spark.api.SparkLogLevel
import org.jetbrains.kotlinx.spark.api.withSpark
import java.util.*

fun main() = withSpark(
    appName = "mysql_extraction_order",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val dbConfig = MySqlConfiguration(spark)

    val database: Database = MySqlDatabase(
        spark = spark,
        host = dbConfig.host,
        port = dbConfig.port,
        database = "db_ecommerce_t",
        user = dbConfig.user,
        password = dbConfig.password
    )

    val orderDf = database.readTable("t_order", Properties())

    orderDf.write().mode(SaveMode.Overwrite).parquet("data/intermediate/ext_t_order.parquet")

    Scripts.endScript(spark)
}