package ru.lyubimov.test.gms.codewars

import kotlin.math.roundToInt

fun gpsMed(s: Int, x: DoubleArray): Int {
    val segments = x.size - 1
    val distance = x.last()
    val time = s * segments
    return (distance / time * 3600).roundToInt()
}

fun gpsMax(s: Int, x: DoubleArray): Int {
    var prevDist = 0.0
    val dists: MutableList<Double> = mutableListOf()
    for (dist in x) {
        dists.add(dist - prevDist)
        prevDist = dist
    }
    val max = dists.max() ?: 0.0
    println(dists)
    return (max * 3600/ s ).roundToInt()
}

fun main(args: Array<String>) {
    println(gpsMed(15, doubleArrayOf(0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25)))
    println(gpsMax(15, doubleArrayOf(0.0, 0.19, 0.5, 0.75, 1.0, 1.25, 1.5, 1.75, 2.0, 2.25)))
}