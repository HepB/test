package ru.lyubimov.test.jb.kotlin.cryptography.logic

interface Logic {

    fun hideMessageInImage(inputFileName: String, outputFileName: String, message: String): Boolean
    fun getMessageFromImage(inputFileName: String): String
    fun exit()
}