package ru.lyubimov.test.jb.search_engine.file

import java.io.File
import java.lang.Exception

object FileProcessor {

    fun getFileByPath(path: String): File {
        val file = File(path)
        if (!file.exists()) throw Exception("Input file not exist")
        return file
    }
}