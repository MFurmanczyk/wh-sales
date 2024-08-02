package io.github.mfurmanczyk.model

import org.apache.spark.sql.types.DataTypes
import org.apache.spark.sql.types.Metadata
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import java.sql.Timestamp

data class Order(
    val id: Int,
    val customer_id: Int? = null,
    val timestamp_order: Timestamp,
    val status_order: Int,
    val status_payment: Int
) {
    companion object {
        val SCHEMA = StructType(arrayOf(
            StructField("id", DataTypes.IntegerType, false, Metadata.empty()),
            StructField("customer_id", DataTypes.IntegerType, true, Metadata.empty()),
            StructField("timestamp_order", DataTypes.TimestampType, false, Metadata.empty()),
            StructField("status_order", DataTypes.IntegerType, false, Metadata.empty()),
            StructField("status_payment", DataTypes.IntegerType, false, Metadata.empty()),
        ))
    }
}
