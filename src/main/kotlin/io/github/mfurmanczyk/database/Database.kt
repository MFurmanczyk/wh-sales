package io.github.mfurmanczyk.database

import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row
import org.apache.spark.sql.SaveMode
import org.jetbrains.kotlinx.spark.api.SparkSession
import java.util.*

/**
 *
 */
abstract class Database {

    /**
     * JDBC driver path (eg. "com.mysql.cj.jdbc.Driver").
     */
    protected abstract val driver: String

    /**
     * Active Spark session for which Database was created.
     */
    protected abstract val spark: SparkSession


    /**
     * Reads given table and saves it into DataFrame.
     *
     * @param table table name in database that is to be read
     * @return DataFrame populated with data.
     */
    abstract fun readTable(table: String, properties: Properties) : Dataset<Row>

    /**
     * Saves given dataframe into table.
     *
     * @param df DataFrame to be saved
     * @param table target table name
     * @param saveMode save mode
     */
    abstract fun writeDataFrame(df: Dataset<Row>, table: String, saveMode: SaveMode, properties: Properties)


}