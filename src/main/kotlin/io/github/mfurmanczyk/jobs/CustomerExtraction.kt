package io.github.mfurmanczyk.jobs

import io.github.mfurmanczyk.database.Database
import io.github.mfurmanczyk.database.MySqlDatabase
import org.apache.spark.sql.SaveMode
import org.jetbrains.kotlinx.spark.api.SparkLogLevel
import org.jetbrains.kotlinx.spark.api.sparkContext
import org.jetbrains.kotlinx.spark.api.withSpark
import java.nio.charset.StandardCharsets
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@OptIn(ExperimentalEncodingApi::class)
fun main() = withSpark(
    appName = "mysql_extraction_customer",
    logLevel = SparkLogLevel.INFO
){

    spark.logInfo {
        """
            ==============PROCESSING BEGIN==============
             Process name: ${spark.sparkContext.appName()}
             Spark version: $sparkVersion
             Timestamp: ${DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").withZone(ZoneOffset.UTC).format(Instant.now())}
        """
    }

    val host = spark.conf().get("spark.jdbc.mysql.host")
    val port = spark.conf().get("spark.jdbc.mysql.port")
    val user = spark.conf().get("spark.jdbc.mysql.user")
    val password = Base64.decode(spark.conf().get("spark.jdbc.mysql.password")).toString(StandardCharsets.UTF_8)

    val database: Database = MySqlDatabase(
        spark = spark,
        host = host,
        port = port,
        database = "db_ecommerce_t",
        user = user,
        password = password
    )

    val customerDf = database.readTable("t_customer", Properties())

    customerDf.write().mode(SaveMode.Overwrite).parquet("data/intermediate/ext_t_customer.parquet")

    spark.logInfo {
        """
            ==============PROCESSING END==============
             Process name: ${spark.sparkContext.appName()}
             Spark version: $sparkVersion
             Timestamp: ${DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").withZone(ZoneOffset.UTC).format(Instant.now())}
        """
    }
}