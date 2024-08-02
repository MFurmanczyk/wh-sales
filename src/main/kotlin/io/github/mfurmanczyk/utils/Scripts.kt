package io.github.mfurmanczyk.utils

import org.jetbrains.kotlinx.spark.api.SparkSession
import org.jetbrains.kotlinx.spark.api.sparkContext
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class Scripts {
    companion object {
        fun startScript(spark: SparkSession) = spark.logInfo {
            """
            ==============PROCESSING BEGIN==============
             Process name: ${spark.sparkContext.appName()}
             Spark version: ${spark.version()}
             Timestamp: ${DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").withZone(ZoneOffset.UTC).format(Instant.now())}
        """
        }

        fun endScript(spark: SparkSession) = spark.logInfo {
            """
            ==============PROCESSING END==============
             Process name: ${spark.sparkContext.appName()}
             Spark version: ${spark.version()}
             Timestamp: ${DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").withZone(ZoneOffset.UTC).format(Instant.now())}
        """
        }
    }
}