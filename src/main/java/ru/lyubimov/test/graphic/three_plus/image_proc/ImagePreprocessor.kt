package ru.lyubimov.test.graphic.three_plus.image_proc

import java.awt.image.BufferedImage

interface ImagePreprocessor {
    fun preprocessImage(image: BufferedImage)
}