package ru.lyubimov.test.graphic.three_plus.image_proc

import java.awt.image.BufferedImage

class VerticalSeamPreprocessor: ImagePreprocessor {

    override fun preprocessImage(image: BufferedImage) {
        val imageEnergyMap = ImageEnergyHolder(image).energyMap
        val verticalEnergyGraph = VerticalEnergyGraph(imageEnergyMap)
        val possibleWays = verticalEnergyGraph.possibleWayForFirst()
        println(verticalEnergyGraph)
    }
}