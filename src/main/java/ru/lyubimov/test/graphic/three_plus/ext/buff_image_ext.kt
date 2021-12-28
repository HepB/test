package ru.lyubimov.test.graphic.three_plus.ext

import ru.lyubimov.test.graphic.three_plus.file.FileType
import ru.lyubimov.test.graphic.three_plus.input.InputData
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import java.lang.Exception
import javax.imageio.ImageIO

fun BufferedImage.saveImage(data: InputData, fileType: FileType = FileType.PNG) {
    val file = File(data.outputFilePath)
    try {
        ImageIO.write(this, fileType.name, file)
    } catch (ex: IOException) {
        throw Exception("Can't save output image")
    }
}

fun BufferedImage.xIndexes() = 0 until width

fun BufferedImage.yIndexes() = 0 until height

fun BufferedImage.maxXIndex() = width - 1

fun BufferedImage.maxYIndex() = height - 1

fun BufferedImage.getColor(x: Int, y: Int) = Color(this.getRGB(x, y))