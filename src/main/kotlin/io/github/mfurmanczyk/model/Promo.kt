package io.github.mfurmanczyk.model

import org.apache.spark.sql.types.DataTypes
import org.apache.spark.sql.types.Metadata
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import java.sql.Date

data class Promo(
    val id: Int,
    val name: String,
    val desc_promo: String? = null,
    val date_start: Date,
    val date_end: Date
) {
    companion object {
        val SCHEMA = StructType(arrayOf(
            StructField("id", DataTypes.IntegerType, false, Metadata.empty()),
            StructField("name", DataTypes.StringType, false, Metadata.empty()),
            StructField("desc_promo", DataTypes.StringType, true, Metadata.empty()),
            StructField("date_start", DataTypes.DateType, false, Metadata.empty()),
            StructField("date_end", DataTypes.DateType, false, Metadata.empty())
        ))
    }
}
