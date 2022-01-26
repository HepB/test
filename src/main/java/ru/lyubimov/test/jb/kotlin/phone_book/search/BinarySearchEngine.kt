package ru.lyubimov.test.jb.kotlin.phone_book.search

class BinarySearchEngine(private val where: List<String>): SearchEngine {

    override fun search(what: List<String>): Int {
        var countOfMatches = 0
        for (element in what) {
            countOfMatches += search(element)
        }
        return countOfMatches
    }

    private fun search(what: String): Int {
        var left = 0
        var right = where.lastIndex

        while (left <= right) {
            val middle = (left + right) / 2
            val element = where[middle]
            if (element == what) {
                return 1
            } else if (what < element) {
                right = middle - 1
            } else {
                left = middle + 1
            }
        }
        return 0
    }
}