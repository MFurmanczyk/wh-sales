package io.github.mfurmanczyk.jobs.transformation

import io.github.mfurmanczyk.model.Promo
import io.github.mfurmanczyk.model.PromoRel
import io.github.mfurmanczyk.utils.Scripts
import org.apache.spark.sql.SaveMode
import org.jetbrains.kotlinx.spark.api.*

fun main() = withSpark(
    appName = "transformation_dim_promo",
    logLevel = SparkLogLevel.INFO
) {

    Scripts.startScript(spark)

    val promoDs = spark.read().parquet("data/intermediate/ext_t_promo.parquet").to<Promo>()
    val promoRelDs = spark.read().parquet("data/intermediate/ext_t_promo_rel.parquet").to<PromoRel>()

    val promoRelAggDf = promoRelDs
        .select(
            promoRelDs("promo_id"),
            promoRelDs("rate_discount")
        )
        .groupBy("promo_id")
        .avg()

    val dimDf = promoDs
        .join(promoRelAggDf, promoDs("id") eq promoRelAggDf("promo_id"))
        .select(
            promoDs("id"),
            promoDs("name"),
            promoDs("desc_promo").alias("description"),
            promoRelAggDf("rate_discount").alias("discount")
        )

    dimDf.write().mode(SaveMode.Overwrite).parquet("data/target/t_promo_dim.parquet")

    Scripts.endScript(spark)
}