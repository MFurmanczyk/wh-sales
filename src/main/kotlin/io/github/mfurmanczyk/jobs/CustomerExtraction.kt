package io.github.mfurmanczyk.jobs

import org.apache.spark.sql.SaveMode
import org.jetbrains.kotlinx.spark.api.SparkLogLevel
import org.jetbrains.kotlinx.spark.api.sparkContext
import org.jetbrains.kotlinx.spark.api.withSpark
import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.collections.set
import kotlin.collections.toString

fun main() = withSpark(
    appName = "mysql_extraction_customer",
    logLevel = SparkLogLevel.INFO
){

    spark.logInfo {
        """
            PROCESSING START: ${spark.sparkContext.appName()}
        """.trimIndent()
    }

    val host =spark.conf().get("spark.jdbc.mysql.host")
    val port = spark.conf().get("spark.jdbc.mysql.port")
    val database = spark.conf().get("spark.jdbc.mysql.database")
    val driver = spark.conf().get("spark.jdbc.mysql.driver")
    val username = spark.conf().get("spark.jdbc.mysql.username")
    val password = Base64.getDecoder().decode(spark.conf().get("spark.jdbc.mysql.password")).toString(StandardCharsets.UTF_8)

    val props = Properties()
    props["user"] = username
    props["password"] = password
    props["driver"] = driver

    spark.logInfo { "MySql configuration retrieved." }

    spark.logInfo {
        """
            CONNECTION INFO: 
            username: $username  
            host: jdbc:mysql://$host:$port/
            database: $database
            JDBC Driver: $driver
        """.trimIndent()
    }

    val customerDf =
        spark.read().jdbc("jdbc:mysql://$host:$port/$database", "t_customer", props)

    spark.logInfo {
        """
            Data read with following schema: ${customerDf.schema().toDDL()}
        """.trimIndent()
    }

    customerDf.write().mode(SaveMode.Overwrite).parquet("data/intermediate/ext_t_customer.parquet")

    spark.logInfo {
        """
           Data saved to parquet file.
        """.trimIndent()
    }

    spark.logInfo {
        """
            PROCESSING END: ${spark.sparkContext.appName()}
        """.trimIndent()
    }
}