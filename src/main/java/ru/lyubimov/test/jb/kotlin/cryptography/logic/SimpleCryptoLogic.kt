package ru.lyubimov.test.jb.kotlin.cryptography.logic

import ru.lyubimov.test.jb.kotlin.cryptography.ext.addEndMark
import ru.lyubimov.test.jb.kotlin.cryptography.ext.toBitQueue
import ru.lyubimov.test.jb.kotlin.cryptography.ext.toByteQueue
import ru.lyubimov.test.jb.kotlin.cryptography.ext.toCryptBytesList
import java.util.*

class SimpleCryptoLogic: CryptoLogic {

    override fun encrypt(message: String, password: String): Queue<Int> {
        val messageBytes = message.encodeToByteArray()
        var passwordBytesQueue = password.encodeToByteArray().toByteQueue()
        val result = LinkedList<Int>()
        for (byte in messageBytes) {
            if (passwordBytesQueue.isEmpty()) {
                passwordBytesQueue = password.encodeToByteArray().toByteQueue()
            }
            val encryptedByte = passwordBytesQueue.poll() xor byte.toInt()
            result.add(encryptedByte)
        }
        return result.addEndMark().toBitQueue()
    }

    override fun decrypt(cryptLetters: List<String>, password: String): String {
        var passwordBytesQueue = password.encodeToByteArray().toByteQueue()
        val rawResult = mutableListOf<Int>()
        for (cryptoLetter in cryptLetters.toCryptBytesList()) {
            if (passwordBytesQueue.isEmpty()) {
                passwordBytesQueue = password.encodeToByteArray().toByteQueue()
            }
            val decodedByte = cryptoLetter xor passwordBytesQueue.poll()
            rawResult.add(decodedByte)
        }
        return rawResult.map { Char(it) }.joinToString("")
    }
}