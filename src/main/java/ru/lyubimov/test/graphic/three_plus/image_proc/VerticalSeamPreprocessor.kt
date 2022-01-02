package ru.lyubimov.test.graphic.three_plus.image_proc

import java.awt.Color
import java.awt.image.BufferedImage

class VerticalSeamPreprocessor: ImagePreprocessor {

    override fun preprocessImage(image: BufferedImage) {
        val imageEnergyMap = ImageEnergyHolder(image).energyMap
        val verticalEnergyGraph = VerticalEnergyGraph(imageEnergyMap)
        verticalEnergyGraph.printGraph()
        println()
        val shortestWay = verticalEnergyGraph.shortestWay()
        println(shortestWay)
        shortestWay.forEach { image.setRGB(it.x, it.y, Color.red.rgb) }
    }
}