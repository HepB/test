package ru.lyubimov.test.jb.kotlin.cryptography.logic

import java.util.*

interface CryptoLogic {

    fun encrypt(message: String, password: String): Queue<Int>
    fun decrypt(cryptLetters: List<String>, password: String): String
}