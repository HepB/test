package ru.lyubimov.test.kotlin.inaction.fundamentals

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader : BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e : NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun main() {
    println(readNumber(BufferedReader(StringReader("2213"))))
}