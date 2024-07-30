package io.github.mfurmanczyk.database

import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.sql.SaveMode
import org.jetbrains.kotlinx.spark.api.SparkSession
import java.util.Properties

class MySqlDatabase(
    override val spark: SparkSession,
    val host: String,
    val port: String,
    val database: String,
    val user: String,
    val password: String
) : Database() {

    override val driver: String = spark.conf().get("spark.jdbc.mysql.driver")

    override fun readTable(table: String, properties: Properties): Dataset<Row> {

        return spark.read()
            .option("user", user)
            .option("password", password)
            .option("driver", driver)
            .jdbc(
                "jdbc:mysql://$host:$port/$database",
                table,
                properties
            )
    }

    override fun writeDataFrame(df: Dataset<Row>, table: String, saveMode: SaveMode, properties: Properties) {
        df.write()
            .mode(saveMode)
            .option("user", user)
            .option("password", password)
            .option("driver", driver)
            .jdbc(
                "jdbc:mysql://$host:$port/$database",
                table,
                properties
            )
    }
}