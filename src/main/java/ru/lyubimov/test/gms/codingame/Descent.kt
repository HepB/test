package ru.lyubimov.test.gms.codingame

fun main() {
    val map: MutableMap<Int, Int> = mutableMapOf(0 to 8, 1 to 9, 2 to 8, 3 to 9)
    map[8] = 22
    println(map)
    map.maxByOrNull { it.value }
}