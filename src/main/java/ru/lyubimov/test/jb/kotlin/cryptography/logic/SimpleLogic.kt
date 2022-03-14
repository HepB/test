package ru.lyubimov.test.jb.kotlin.cryptography.logic

import ru.lyubimov.test.jb.kotlin.cryptography.ext.*
import java.awt.Color
import java.awt.image.BufferedImage
import kotlin.system.exitProcess

class SimpleLogic(private val cryptoLogic: CryptoLogic) : Logic {

    override fun hideMessageInImage(
        inputFileName: String,
        outputFileName: String,
        message: String,
        password: String
    ): Boolean {
        val image = inputFileName.toBufferedImage()
        val isSuccess = hide(image, message, password)
        if (isSuccess) {
            image.saveImage(outputFileName)
        }
        return isSuccess
    }

    override fun getMessageFromImage(inputFileName: String, password: String): String {
        val image = inputFileName.toBufferedImage()
        return getMessage(image, password)
    }

    override fun exit() {
        println("Bye!")
        exitProcess(0)
    }

    private fun hide(image: BufferedImage, message: String, password: String): Boolean {
        val maxBytes = image.width * image.height
        val cryptBitsQueue = cryptoLogic.encrypt(message, password)
        if (maxBytes < cryptBitsQueue.size) return false

        mainLoop@ for (i in image.yIndexes()) {
            for (j in image.xIndexes()) {
                if (cryptBitsQueue.isEmpty()) break@mainLoop
                val color = Color(image.getRGB(j, i))
                val red = color.red
                val green = color.green
                val blue = if (cryptBitsQueue.poll() == 0) {
                    color.blue and 0b11111110
                } else {
                    color.blue or 1
                }
                val newColor = Color(red, green, blue)
                image.setRGB(j, i, newColor.rgb)
            }
        }
        return true
    }

    private fun getMessage(image: BufferedImage, password: String): String {
        var rawByte = ""
        var cryptBytesList = mutableListOf<String>()
        loop@ for (i in image.yIndexes()) {
            for (j in image.xIndexes()) {
                val color = Color(image.getRGB(j, i))
                val messageBit = color.blue and 1
                rawByte += messageBit
                if (rawByte.length == 8) {
                    cryptBytesList.add(rawByte)
                    rawByte = ""
                    if (cryptBytesList.hasEndOfMessage()) {
                        cryptBytesList = cryptBytesList.dropLast(3).toMutableList()
                        break@loop
                    }
                }
            }
        }
        return cryptoLogic.decrypt(cryptBytesList, password)
    }
}