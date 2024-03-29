package ru.lyubimov.test.kotlin.inaction.fundamentals

import ru.lyubimov.test.kotlin.inaction.fundamentals.Color.*

enum class Color(val r: Int, val g : Int, val b : Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(7, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r*256 + g) *256 + b
}

fun getWarmth(color: Color) = when(color) {
    RED, ORANGE, YELLOW -> "теплый"
    GREEN -> "нейтральный"
    BLUE, INDIGO, VIOLET -> "холодный"
}

fun mix(c1: Color, c2: Color) = when(setOf(c1, c2)) {
    setOf(RED, YELLOW) -> ORANGE
    setOf(YELLOW, BLUE) -> GREEN
    setOf(BLUE, VIOLET) -> INDIGO
    else -> throw Exception("Грязный цвет")
}

fun main() {
    println(getWarmth(Color.VIOLET))
    println(mix(RED, YELLOW))
}