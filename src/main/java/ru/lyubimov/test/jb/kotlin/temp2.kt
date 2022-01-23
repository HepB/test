package ru.lyubimov.test.jb.kotlin

import kotlin.math.sqrt

fun main() {
    val numbers = List(98) { i -> i + 1}
    val step = sqrt(numbers.size.toDouble()).toInt()
    println(step)
    for (i in numbers.indices step step) {
        println("$i to ${numbers[i]}")
    }
}