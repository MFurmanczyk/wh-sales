package io.github.mfurmanczyk.model

import org.apache.spark.sql.types.DataTypes
import org.apache.spark.sql.types.Metadata
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType

data class PromoRel(
    val promo_id: Int,
    val product_id: Int? = null,
    val category_id: Int? = null,
    val rate_discount: Double
) {
    companion object {
        val SCHEMA = StructType(arrayOf(
            StructField("promo_id", DataTypes.IntegerType, false, Metadata.empty()),
            StructField("product_id", DataTypes.IntegerType, true, Metadata.empty()),
            StructField("category_id", DataTypes.IntegerType, true, Metadata.empty()),
            StructField("rate_discount", DataTypes.DoubleType, false, Metadata.empty()),
        ))
    }
}
