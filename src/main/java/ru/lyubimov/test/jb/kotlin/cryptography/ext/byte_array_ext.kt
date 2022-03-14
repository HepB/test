package ru.lyubimov.test.jb.kotlin.cryptography.ext

import java.util.*

fun ByteArray.toByteQueue(): Queue<Int> {
    val rawBits = this.toList().map { it.toInt() }
    return LinkedList(rawBits)
}