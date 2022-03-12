package ru.lyubimov.test.jb.kotlin.cryptography.ext

import ru.lyubimov.test.jb.kotlin.cryptography.FileType
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

fun BufferedImage.saveImage(outputFilePath: String, fileType: FileType = FileType.PNG) {
    val file = File(outputFilePath)
    try {
        ImageIO.write(this, fileType.name, file)
    } catch (ex: IOException) {
        throw Exception("Can't save output image")
    }
}

fun BufferedImage.xIndexes() = 0 until width

fun BufferedImage.yIndexes() = 0 until height