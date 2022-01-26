package ru.lyubimov.test.kotlin

fun main() {
    val numbers = mutableListOf(1, 3, 5)
    numbers.add(0, 3)
    val sublist = numbers.subList(0, 2)
    sublist.add(1, 3)
    println(numbers)
}