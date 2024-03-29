package ru.lyubimov.test.jb.kotlin.search_engine

import ru.lyubimov.test.jb.kotlin.search_engine.file.FileProcessor
import ru.lyubimov.test.jb.kotlin.search_engine.input.InputProcessor
import ru.lyubimov.test.jb.kotlin.search_engine.menu.Menu

fun main(args: Array<String>) {
    val inputData = InputProcessor.readInputData(args)
    val file = FileProcessor.getFileByPath(inputData.inputFilePath)
    Menu(file.readLines())
}

