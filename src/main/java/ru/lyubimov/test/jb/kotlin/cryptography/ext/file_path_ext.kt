package ru.lyubimov.test.jb.kotlin.cryptography.ext

import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import java.lang.Exception
import javax.imageio.ImageIO

fun FilePath.toBufferedImage(): BufferedImage {
    val file = File(this)
    if (!file.exists()) throw Exception("Can't read input file!")
    try {
        return ImageIO.read(file)
    } catch (ex: IOException) {
        throw Exception("Input file data is not correct")
    }
}