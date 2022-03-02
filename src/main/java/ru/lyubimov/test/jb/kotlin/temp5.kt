package ru.lyubimov.test.jb.kotlin

fun main() {
    val first = "1 + 1"
    val second = "-2"
    val third = "2-"
    val fourth = "-2 + 2 - 3 + 2"
    println(isCorrect(first))
    println(isCorrect(second))
    println(isCorrect(third))
    println(isCorrect(fourth))
    println(2 % 2)
    val n = 1
    println(0x3A)
    println(0b10010)
}
private fun isCorrect(line: String): Boolean = line.matches("[+\\-]?\\d+( [+\\-] [+\\-]?\\d+)*".toRegex())