package ru.lyubimov.test.jb.kotlin.search_engine.ext

fun List<String>.toInvertedIndexMap(): Map<String, List<Int>> {
    val result = mutableMapOf<String, MutableList<Int>>()

    forEachIndexed { index, line ->
        line.split(" ").forEach { word ->
            val key = word.uppercase()
            if (result.containsKey(key)) {
                result[key]?.add(index)
            } else {
                result[key] = mutableListOf(index)
            }
        }
    }
    return result
}