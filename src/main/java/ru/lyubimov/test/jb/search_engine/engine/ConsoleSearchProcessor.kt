package ru.lyubimov.test.jb.search_engine.engine

import ru.lyubimov.test.jb.search_engine.menu.SearchStrategy

object ConsoleSearchProcessor {

    private const val MESSAGE_ENTER_SEARCH_DATA = "Enter a name or email to search all suitable people."
    private const val MESSAGE_RESULT_UNKNOWN = "No matching people found."
    private const val MESSAGE_SELECT_SEARCH_STRATEGY = "Select a matching strategy: ALL, ANY, NONE"

    fun find(invertedIndexData: Map<String, List<Int>>, data: List<String>) {
        val strategy = getSearchStrategy()
        val query = getQuery()
        when (strategy) {
            SearchStrategy.ANY -> findAnyByInvertedIndex(query, invertedIndexData, data)
            SearchStrategy.ALL -> findAll(query, data)
            SearchStrategy.NONE -> findNoneByInvertedIndex(query, data)
        }
    }

    fun printAllLines(data: List<String>) {
        println("=== List of people ===")
        data.forEach { println(it) }
    }

    private fun findAll(query: String, data: List<String>) {
        val result: List<String> = data.filter { it.contains(query, true) }
        printResult(result)
    }

    private fun findAnyByInvertedIndex(query: String, invertedIndexData: Map<String, List<Int>>, data: List<String>) {
        val words = query.split(" ")
        val result = mutableSetOf<String>()
        words.forEach {
            val key = it.uppercase()
            if (invertedIndexData.containsKey(key)) {
                val indexesOfLines = invertedIndexData[key]
                indexesOfLines?.forEach { index -> result.add(data[index]) }
            }
        }
        printResult(result)
    }

    private fun findNoneByInvertedIndex(query: String, data: List<String>) {
        val words = query.split(" ")
        val result = data.toMutableList()
        words.forEach { word -> result.removeIf { it.contains(word, true) }}
        printResult(result)
    }

    private fun printResult(result: Collection<String>) {
        if (result.isEmpty()) {
            println(MESSAGE_RESULT_UNKNOWN)
        } else {
            println("${result.size} persons found:")
            result.forEach { println(it) }
        }
    }

    private fun getSearchStrategy(): SearchStrategy {
        println(MESSAGE_SELECT_SEARCH_STRATEGY)
        val input = readLine()!!
        val strategy = SearchStrategy.valueOf(input.uppercase())
        println()
        return strategy
    }

    private fun getQuery(): String {
        println(MESSAGE_ENTER_SEARCH_DATA)
        return readLine()!!
    }
}