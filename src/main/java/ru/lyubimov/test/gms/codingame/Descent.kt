package ru.lyubimov.test.gms.codingame

fun main(args: Array<String>) {
    val list = mutableListOf(8, 9, 6, 7, 5, 4, 3, 2, 1)
    val map: MutableMap<Int, Int> = mutableMapOf(0 to 8, 1 to 9, 2 to 8, 3 to 9)
    map[8] = 22
    println(map)
    map.maxBy { it.value }
}