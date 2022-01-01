package ru.lyubimov.test.graphic.three_plus.image_proc

class VerticalEnergyGraph(energyMap: Array<Array<Double>>) : EnergyGraph() {

    override val graph: List<Vertex>
    private val createdVertexes = mutableMapOf<Pixel, Vertex>()

    init {
        val result = mutableListOf<Vertex>()

        for (j in energyMap[0].indices) {
            val pixel = Pixel(x = j, y = 0, energy = energyMap[0][j])
            val adjacentVertexes = getPixelAdjacent(pixel, energyMap)
            result.add(
                Vertex(
                    value = pixel,
                    outputVertexes = adjacentVertexes
                )
            )
        }

        graph = result
        createdVertexes.clear()
    }

    private fun getPixelAdjacent(pixel: Pixel, energyMap: Array<Array<Double>>): List<Vertex> {
        val result = mutableListOf<Vertex>()

        if (pixel.x - 1 >= 0 && pixel.y + 1 <= energyMap.lastIndex) {
            val adjacentPixel = Pixel(
                x = pixel.x - 1,
                y = pixel.y + 1,
                energy = energyMap[pixel.x - 1][pixel.y + 1]
            )
            var createdVertex = createdVertexes[adjacentPixel]
            if (createdVertex == null) {
                createdVertex = Vertex(
                    value = adjacentPixel,
                    outputVertexes = getPixelAdjacent(adjacentPixel, energyMap)
                )
                createdVertexes[adjacentPixel] = createdVertex
                result.add(createdVertex)
            }
            result.add(createdVertex)
        }

        if (pixel.y + 1 <= energyMap.lastIndex) {
            val adjacentPixel = Pixel(
                x = pixel.x,
                y = pixel.y + 1,
                energy = energyMap[pixel.x][pixel.y + 1]
            )
            var createdVertex = createdVertexes[adjacentPixel]
            if (createdVertex == null) {
                createdVertex = Vertex(
                    value = adjacentPixel,
                    outputVertexes = getPixelAdjacent(adjacentPixel, energyMap)
                )
                createdVertexes[adjacentPixel] = createdVertex
                result.add(createdVertex)
            }
            result.add(createdVertex)
        }

        if (pixel.x + 1 <= energyMap[0].lastIndex && pixel.y + 1 <= energyMap.lastIndex) {
            val adjacentPixel = Pixel(
                x = pixel.x + 1,
                y = pixel.y + 1,
                energy = energyMap[pixel.x + 1][pixel.y + 1]
            )
            var createdVertex = createdVertexes[adjacentPixel]
            if (createdVertex == null) {
                createdVertex = Vertex(
                    value = adjacentPixel,
                    outputVertexes = getPixelAdjacent(adjacentPixel, energyMap)
                )
                createdVertexes[adjacentPixel] = createdVertex
                result.add(createdVertex)
            }
            result.add(createdVertex)
        }
        return result
    }
}