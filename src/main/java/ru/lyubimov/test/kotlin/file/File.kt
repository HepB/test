package ru.lyubimov.test.kotlin.file

import java.io.File

fun longestLineInTextFile(path: String): String? {
    val file = File(path)
    var result: String? = null
    if (!file.exists()) {
        return null
    }
    val lines = file.readLines()
    for (line in lines){
        if (result == null || result.length < line.length) {
            result = line
        }
    }
    return result
}

fun getLinesFromFile(path: String): List<String>? {
    val file = File(path)
    return if (!file.exists()) {
        null
    } else {
        file.readLines()
    }
}

fun wordsInLine(line: String) = line.trim().split(Regex("\\s+"))

fun main() {
    println(longestLineInTextFile("C:\\java\\test\\src\\main\\java\\ru\\lyubimov\\test\\kotlin\\file\\words_sequence.txt")?.length)
    println(wordsInLine(getLinesFromFile("C:\\java\\test\\src\\main\\java\\ru\\lyubimov\\test\\kotlin\\file\\text.txt")!![0]).size)
}