package ru.lyubimov.test.jb.kotlin

import java.math.BigDecimal
import java.math.BigInteger

fun Int.lastDigit(): Int {
    val word = this.toString()
    return word.last().digitToInt()
}

fun main() {
    println('2'.digitToInt().toBigDecimal().divide(10.toBigDecimal().pow(1 + 0)))
}

fun f(n: Int): Int = if (n > 2) f(n - 1) + f(n - 2) + f(n - 3) else n

data class Pog(var isPog: Boolean = false)

fun <T, U> lalalend(t: T, u: U): T {
    return t
}