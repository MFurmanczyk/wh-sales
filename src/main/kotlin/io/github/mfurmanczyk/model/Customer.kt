package io.github.mfurmanczyk.model

import org.apache.spark.sql.types.DataTypes
import org.apache.spark.sql.types.Metadata
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import java.io.Serializable
import java.sql.Date

data class Customer (
    val id                      : Int,
    val name                    : String,
    val name_2                  : String? = null,
    val surname                 : String,
    val gender                  : String,
    val email_address           : String,
    val phone_number            : String? = null,
    val date_birth              : Date,
    val date_join               : Date,
    val address_street          : String,
    val address_street2         : String? = null,
    val address_city            : String,
    val address_state           : String,
    val address_postal_code     : String,
    val address_country_iso_2   : String
) : Serializable {
    companion object {
        val SCHEMA = StructType(arrayOf(
            StructField("id", DataTypes.IntegerType, false, Metadata.empty()),
            StructField("name", DataTypes.StringType, false, Metadata.empty()),
            StructField("name_2", DataTypes.StringType, true, Metadata.empty()),
            StructField("surname", DataTypes.StringType, false, Metadata.empty()),
            StructField("gender", DataTypes.StringType, false, Metadata.empty()),
            StructField("email_address", DataTypes.StringType, false, Metadata.empty()),
            StructField("phone_number", DataTypes.StringType, true, Metadata.empty()),
            StructField("date_birth", DataTypes.DateType, false, Metadata.empty()),
            StructField("date_join", DataTypes.DateType, false, Metadata.empty()),
            StructField("address_street", DataTypes.StringType, false, Metadata.empty()),
            StructField("address_street2", DataTypes.StringType, true, Metadata.empty()),
            StructField("address_city", DataTypes.StringType, false, Metadata.empty()),
            StructField("address_state", DataTypes.StringType, false, Metadata.empty()),
            StructField("address_postal_code", DataTypes.StringType, false, Metadata.empty()),
            StructField("address_country_iso_2", DataTypes.StringType, false, Metadata.empty()),
        ))
    }
}