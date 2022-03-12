package ru.lyubimov.test.jb.kotlin.cryptography.ext

import java.util.*

fun ByteArray.toMessageBytesWithEndMark(): ByteArray {
    return ByteArray(this.size + 3) { i ->
        when (i) {
            in this.indices -> this[i]
            this.lastIndex + 3 -> 3
            else -> 0
        }
    }
}

fun ByteArray.toBitQueue(): Queue<Int> {
    val rawBits = this.joinToString("") { it.toString(2).padStart(8, '0') }.toList().map { it.digitToInt() }
    return LinkedList(rawBits)
}