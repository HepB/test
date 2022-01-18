package ru.lyubimov.test.file

import java.io.File

fun main() {
    val mainDirectory = File("/Projects")
    val labDirectory = mainDirectory.resolve("Programming")
    val reportFile = labDirectory.resolve("Report.pdf")
    val project1 = labDirectory.resolve("Project1")
    mainDirectory.mkdir()
    labDirectory.mkdir()
    reportFile.createNewFile()
    project1.mkdir()
}