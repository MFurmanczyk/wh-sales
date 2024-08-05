package io.github.mfurmanczyk.model

import org.apache.spark.sql.types.DataTypes
import org.apache.spark.sql.types.Metadata
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType

data class Product(
    val id: Int,
    val category_id: Int? = null,
    val name: String,
    val price: Double,
    val desc_product: String? = null
) {
    companion object {
        val SCHEMA = StructType(arrayOf(
            StructField("id", DataTypes.IntegerType, false, Metadata.empty()),
            StructField("category_id", DataTypes.IntegerType, true, Metadata.empty()),
            StructField("name", DataTypes.StringType, false, Metadata.empty()),
            StructField("price", DataTypes.DoubleType, false, Metadata.empty()),
            StructField("desc_product", DataTypes.StringType, true, Metadata.empty()),
        ))
    }
}
