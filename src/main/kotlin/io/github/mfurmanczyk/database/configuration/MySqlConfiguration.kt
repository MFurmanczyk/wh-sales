package io.github.mfurmanczyk.database.configuration

import org.jetbrains.kotlinx.spark.api.SparkSession
import java.nio.charset.StandardCharsets
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

data class MySqlConfiguration(
    val spark: SparkSession
) {
    val host: String = spark.conf().get("spark.jdbc.mysql.host")
    val port: String = spark.conf().get("spark.jdbc.mysql.port")
    val user: String = spark.conf().get("spark.jdbc.mysql.user")
    @OptIn(ExperimentalEncodingApi::class)
    val password: String = Base64.decode(spark.conf().get("spark.jdbc.mysql.password")).toString(StandardCharsets.UTF_8)
}