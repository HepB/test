package ru.lyubimov.test.jb.kotlin.cryptography.ext

import java.math.BigInteger

fun List<String>.hasEndOfMessage(): Boolean {
    val lastSymbol = "00000011"
    val zeroSymbol = "00000000"
    return when {
        size < 3 -> false
        lastOrNull() == lastSymbol && this[lastIndex - 1] == zeroSymbol && this[lastIndex - 2] == zeroSymbol -> true
        else -> false
    }
}

fun List<String>.decodeMessage(): String {
    return this.map { BigInteger(it, 2) }.map { Char(it.toInt()) }.joinToString("")
}