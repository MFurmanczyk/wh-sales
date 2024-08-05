package io.github.mfurmanczyk.utils

import kotlin.math.round

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}
fun calculateSaleValue(unitPrice: Double, unitCount: Long, discount: Double?): Double {

    val actualDiscount: Double = discount ?: 0.0
    return (unitCount * (unitPrice * (1 - actualDiscount))).round(2)
}

