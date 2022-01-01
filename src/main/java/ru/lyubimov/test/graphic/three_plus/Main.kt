package ru.lyubimov.test.graphic.three_plus

import ru.lyubimov.test.graphic.three_plus.ext.saveImage
import ru.lyubimov.test.graphic.three_plus.image_proc.ImagePreprocessor
import ru.lyubimov.test.graphic.three_plus.image_proc.VerticalSeamPreprocessor
import ru.lyubimov.test.graphic.three_plus.input.InputPreprocessor


fun main(args: Array<String>) {
    val inputData = InputPreprocessor.readInputData(args)
    // val preprocessor: ImagePreprocessor = NegativePreprocessor()
    // val preprocessor: ImagePreprocessor = PixelEnergyPreprocessor()
    val preprocessor: ImagePreprocessor = VerticalSeamPreprocessor()
    val image = inputData.getImage()
    preprocessor.preprocessImage(image)
    image.saveImage(inputData)
}







