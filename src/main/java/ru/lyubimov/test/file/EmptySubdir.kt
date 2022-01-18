package ru.lyubimov.test.file

import java.io.File
import java.io.FileFilter

fun main() {
    val dir = File("basedir")
    val fileTreeWalk = dir.walk(FileWalkDirection.TOP_DOWN)
    val maxFileDir = fileTreeWalk.filter { it.isDirectory }
            .filter { it.listFiles(FileFilter { it.isDirectory }).isEmpty() }.maxByOrNull { it.list().size }
    println("${maxFileDir!!.name.substringAfter("/")} ${maxFileDir.list().size}")
}