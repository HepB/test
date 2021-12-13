package ru.lyubimov.test.graphic.two

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import javax.imageio.ImageIO

const val ARG_INPUT = "-in"
const val ARG_OUTPUT = "-out"
const val TYPE = "png"

fun main(args: Array<String>) {
    val inputData = readInputData(args)
    val image = getImage(inputData)
    preprocessImage(image)
    saveImage(image, inputData)
}

fun readInputData(args: Array<String>): InputData {
    var inputFilePath= ""
    var outputFilePath= ""

    for (index in args.indices step 2) {
        when (args[index]) {
            ARG_INPUT -> {
                try {
                    inputFilePath = args[index + 1]
                } catch (ex: IndexOutOfBoundsException) {
                    throw Exception("Enter input file path")
                }
            }
            ARG_OUTPUT -> {
                try {
                    outputFilePath = args[index + 1]
                } catch (ex: IndexOutOfBoundsException) {
                    throw Exception("Enter output file path")
                }
            }
            else -> throw Exception("Incorrect argument")
        }
    }

    when {
        !isFilePathCorrect(inputFilePath) -> throw Exception("Enter correct input file path")
        !isFilePathCorrect(outputFilePath) -> throw Exception("Enter correct output file path")
    }

    return InputData(
        inputFilePath = inputFilePath,
        outputFilePath = outputFilePath
    )
}

fun getImage(inputData: InputData): BufferedImage {
    val file = File(inputData.inputFilePath)
    if (!file.exists()) throw Exception("Input file not exist")
    try {
        return ImageIO.read(file)
    } catch (ex: IOException) {
        throw Exception("Input file data is not correct")
    }
}

fun preprocessImage(image: BufferedImage) {
    with(image) {
        for (i in 0 until  height) {
            for (j in 0 until width) {
                val currentColor = getRGB(j, i)
                setRGB(j, i, invertRgb(currentColor))
            }
        }
    }
}

private fun isFilePathCorrect(path: String): Boolean {
    val regex = Regex(".+[.]$TYPE\$")
    return path.trim().matches(regex)
}

private fun invertRgb(originalRgb: Int): Int {
    val originalColor = Color(originalRgb)
    val invertedRed = 255 - originalColor.red
    val invertedGreen = 255 - originalColor.green
    val invertedBlue = 255 - originalColor.blue
    return Color(invertedRed, invertedGreen, invertedBlue).rgb
}

fun saveImage(image: BufferedImage, data: InputData) {
    val file = File(data.outputFilePath)
    try {
        ImageIO.write(image, TYPE, file)
    } catch (ex: IOException) {
        throw Exception("Can't save output image")
    }
}

data class InputData(
    val inputFilePath: String,
    val outputFilePath: String
)




