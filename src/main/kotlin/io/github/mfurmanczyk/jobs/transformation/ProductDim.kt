package io.github.mfurmanczyk.jobs.transformation

import io.github.mfurmanczyk.model.Category
import io.github.mfurmanczyk.model.Product
import io.github.mfurmanczyk.utils.Scripts
import org.apache.spark.sql.SaveMode
import org.jetbrains.kotlinx.spark.api.*

fun main() = withSpark(
    appName = "transformation_dim_product",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val productDs = spark.read().parquet("data/intermediate/ext_t_product.parquet").to<Product>()
    val categoryDs = spark.read().parquet("data/intermediate/ext_t_category.parquet").to<Category>()

    val dimDf = productDs
        .join(categoryDs, productDs("category_id") eq categoryDs("id"))
        .select(
            productDs("id"),
            productDs("name"),
            productDs("price"),
            productDs("desc_product").alias("description"),
            categoryDs("id").alias("category_id"),
            categoryDs("name").alias("category_name"),
            categoryDs("desc_category").alias("category_description"),
            categoryDs("type_liquidity").alias("liquidity")
        )

    dimDf.write().mode(SaveMode.Overwrite).parquet("data/target/t_product_dim.parquet")

    Scripts.endScript(spark)
}