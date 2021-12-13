package ru.lyubimov.test.graphic.one

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

const val WIDTH_MESSAGE = "Enter rectangle width:"
const val HEIGHT_MESSAGE = "Enter rectangle height:"
const val IMAGE_NAME_MESSAGE = "Enter output image name:"

fun main() {
    val imageData = readInitialData()
    val image = createImage(data = imageData)
    saveImage(image = image, data = imageData)
}

private fun readInitialData(): ImageData {
    println(WIDTH_MESSAGE)
    val width = readLine()!!.toInt()
    println(HEIGHT_MESSAGE)
    val height = readLine()!!.toInt()
    println(IMAGE_NAME_MESSAGE)
    val imageName = readLine()!!
    return ImageData(
        width = width, height = height, imageName = imageName
    )
}

private fun createImage(data: ImageData): BufferedImage {
    val image = BufferedImage(data.width, data.height, BufferedImage.TYPE_INT_RGB)
    val color = Color.red.rgb
    val maxWidthIndex = data.width - 1
    val maxHeightIndex = data.height - 1

    with(data.sideRatio) {

        for (i in 0..maxHeightIndex) {
            for (j in 0..maxWidthIndex) {
                when {
                    isWidthBigger && j - weight < i * weight && j >= weight * i -> image.setRGB(j, i, color)
                    isWidthBigger && j + weight > maxWidthIndex - i * weight && j <= maxWidthIndex - i * weight -> image.setRGB(
                        j, i, color
                    )
                    !isWidthBigger && i - weight < j * weight && i >= weight * j -> image.setRGB(j, i, color)
                    !isWidthBigger && i + weight > maxHeightIndex - j * weight && i <= maxHeightIndex - j * weight -> image.setRGB(
                        j, i, color
                    )
                }
            }
        }
    }
    return image
}

private fun saveImage(image: BufferedImage, data: ImageData) {
    val file = File(data.imageName)
    ImageIO.write(image, "png", file)
}

private data class ImageData(
    val width: Int,
    val height: Int,
    val imageName: String,
) {
    val sideRatio: SideRatio = if (width >= height) {
        SideRatio(width / height, true)
    } else {
        SideRatio(height / width, false)
    }

    data class SideRatio(
        val weight: Int, val isWidthBigger: Boolean
    )
}