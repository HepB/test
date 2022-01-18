package ru.lyubimov.test.jb

fun isPrime(number: Int): Int {
    for (i in 2..(number / 2)) {
        if (number % i != 0)
            continue
        else
            return i
    }
    return number
}

fun main() {
    val result = isPrime(5977)
    println(result)
    val set = setOf(1, 2, 3)
}