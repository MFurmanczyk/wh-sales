package io.github.mfurmanczyk.model

import org.apache.spark.sql.types.DataTypes
import org.apache.spark.sql.types.Metadata
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType

data class OrderRel(
    val order_id: Int,
    val product_id: Int,
    val quantity_product: UInt
) {
    companion object {
        val SCHEMA = StructType(arrayOf(
            StructField("order_id", DataTypes.IntegerType, false, Metadata.empty()),
            StructField("product_id", DataTypes.IntegerType, false, Metadata.empty()),
            StructField("quantity_product", DataTypes.IntegerType, false, Metadata.empty())
        ))
    }
}
