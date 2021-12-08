package ru.lyubimov.test.kotlin

fun main() {
    println(reverseNumber(1234L))
}

fun reverseNumber(number: Long): Long {
    return doReverseNumber(number, 0)
}

fun doReverseNumber(number: Long, x: Long): Long {
    return if (number == 0L) {
        x
    } else {
        doReverseNumber(number / 10, x * 10 + number % 10)
    }
}