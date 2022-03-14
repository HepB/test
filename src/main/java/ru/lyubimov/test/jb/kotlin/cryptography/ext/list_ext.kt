package ru.lyubimov.test.jb.kotlin.cryptography.ext

import java.math.BigInteger
import java.util.*

fun List<String>.hasEndOfMessage(): Boolean {
    val lastSymbol = "00000011"
    val zeroSymbol = "00000000"
    return when {
        size < 3 -> false
        lastOrNull() == lastSymbol && this[lastIndex - 1] == zeroSymbol && this[lastIndex - 2] == zeroSymbol -> true
        else -> false
    }
}

fun List<String>.toCryptBytesList(): List<Int> {
    return this.map { BigInteger(it, 2).toInt() }
}

fun List<Int>.toBitQueue(): Queue<Int> {
    val rawBits = this.joinToString("") { it.toString(2).padStart(8, '0') }.toList().map { it.digitToInt() }
    return LinkedList(rawBits)
}

fun List<Int>.addEndMark(): List<Int> {
    val result = this.toMutableList()
    result.add(0)
    result.add(0)
    result.add(3)
    return result
}