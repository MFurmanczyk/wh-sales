package io.github.mfurmanczyk.model

import org.apache.spark.sql.types.DataTypes
import org.apache.spark.sql.types.Metadata
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType

data class Category(
    val id              : Int,
    val name            : String,
    val desc_category   : String? = null,
    val type_liquidity  : Int,
) {
    companion object {
        val SCHEMA = StructType(arrayOf(
            StructField("id", DataTypes.IntegerType, false, Metadata.empty()),
            StructField("name", DataTypes.StringType, false, Metadata.empty()),
            StructField("desc_category", DataTypes.StringType, true, Metadata.empty()),
            StructField("type_liquidity", DataTypes.ShortType, false, Metadata.empty()),
        ))
    }
}
