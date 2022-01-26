package ru.lyubimov.test.jb.kotlin.phone_book.file

import java.io.File
import java.lang.Exception

typealias FilePath = String

fun FilePath.getFile(): File {
    val file = File(this)
    if (!file.exists()) throw Exception("Input file not exist")
    return file
}

fun File.linesWithoutPhone(): MutableList<String> = this.readLines().map { it.substringAfter(" ") }.toMutableList()