package ru.lyubimov.test.graphic.three_plus.image_proc

abstract class EnergyGraph {
    abstract val graph: List<Vertex>

    fun possibleWayForFirst() = possibleWays(graph.first())

    private fun possibleWays(
        initialVertex: Vertex
    ): List<Way> {
        val result = mutableListOf<Way>()
        return result
    }
}