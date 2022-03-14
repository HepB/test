package ru.lyubimov.test.jb.kotlin.cryptography.logic

interface Logic {

    fun hideMessageInImage(inputFileName: String, outputFileName: String, message: String, password: String): Boolean
    fun getMessageFromImage(inputFileName: String, password: String): String
    fun exit()
}