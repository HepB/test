package ru.lyubimov.test.graphic.three_plus

import ru.lyubimov.test.graphic.three_plus.ext.rotate
import ru.lyubimov.test.graphic.three_plus.ext.saveImage
import ru.lyubimov.test.graphic.three_plus.image_proc.VerticalSeamPreprocessor
import ru.lyubimov.test.graphic.three_plus.input.InputPreprocessor


fun main(args: Array<String>) {
    val inputData = InputPreprocessor.readInputData(args)
    // val preprocessor: ImagePreprocessor = NegativePreprocessor()
    // val preprocessor: ImagePreprocessor = PixelEnergyPreprocessor()
    val preprocessor = VerticalSeamPreprocessor()
    var image = preprocessor.removeColumns(inputData.getImage(), inputData.widthForRemove)
    image = image.rotate(90)
    image = preprocessor.removeColumns(image, inputData.heightForRemove)
    image = image.rotate(270)
    image.saveImage(inputData)
}