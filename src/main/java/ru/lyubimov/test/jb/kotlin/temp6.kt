package ru.lyubimov.test.jb.kotlin

import java.math.BigDecimal
import java.math.BigInteger

fun Int.lastDigit(): Int {
    val word = this.toString()
    return word.last().digitToInt()
}

fun main() {
    println('2'.digitToInt().toBigDecimal().divide(10.toBigDecimal().pow(1 + 0)))
    // Standard foreground colors
    for (i in 0..15) print("\u001b[38;5;${i}m ${"%3d".format(i)}")

// 216 foreground colors
    for (i in 16..231) {
        if ((i - 16) % 36 == 0) println()
        print("\u001b[38;5;${i}m ${"%3d".format(i)}")
    }
    println("\u001B[0m")

// Foreground grayscale shades
    for (i in 232..255) print("\u001b[38;5;${i}m ${"%3d".format(i)}")
    println()

// Standard background colors
    for (i in 0..15) print("\u001b[48;5;${i}m ${"%3d".format(i)}")

// 216 background colors
    for (i in 16..231) {
        if ((i - 16) % 36 == 0) println("\u001B[0m")
        print("\u001b[48;5;${i}m ${"%3d".format(i)}")
    }
    println("\u001B[0m")

// Background grayscale shades
    for (i in 232..255) print("\u001b[48;5;${i}m ${"%3d".format(i)}")
    println("\u007B")
}

fun f(n: Int): Int = if (n > 2) f(n - 1) + f(n - 2) + f(n - 3) else n

data class Pog(var isPog: Boolean = false)

fun <T, U> lalalend(t: T, u: U): T {
    return t
}