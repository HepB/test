package ru.lyubimov.test.jb

fun main() {
    var fibonacciPrevious = 1
    var fibonacciCurrent = 1
    var fibonacciSum = fibonacciPrevious + fibonacciCurrent

    while(fibonacciCurrent < 1001) {
        val tmp = fibonacciPrevious + fibonacciCurrent
        fibonacciPrevious = fibonacciCurrent
        fibonacciCurrent = tmp
        fibonacciSum += fibonacciCurrent
    }

    val collection = listOf(2)
}