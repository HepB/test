package ru.lyubimov.test.graphic.three_plus.image_proc

import ru.lyubimov.test.graphic.three_plus.ext.*
import java.awt.Color
import java.awt.image.BufferedImage

class PixelEnergyPreprocessor : ImagePreprocessor {

    override fun preprocessImage(image: BufferedImage) {
        val imageEnergyHolder = ImageEnergyHolder(image)
        for (i in image.yIndexes()){
            for (j in image.xIndexes()) {
                val energy = imageEnergyHolder.energyMap[i][j]
                val intensity = intensity(energy = energy, maxEnergy = imageEnergyHolder.maxEnergyOfImage)
                val energyColor = Color(intensity, intensity, intensity).rgb
                image.setRGB(j, i, energyColor)
            }
        }
    }

    private fun intensity(energy: Double, maxEnergy: Double) = (255.0 * energy / maxEnergy).toInt()
}