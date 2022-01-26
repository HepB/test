package ru.lyubimov.test.jb.kotlin.phone_book.search

class LinearSearchEngine(private val where: List<String>): SearchEngine {

    override fun search(what: List<String>): Int {
        var count = 0
        for (whatLine in what) {
            inner@ for (whereLine in where) {
                if (whereLine == whatLine) {
                    count++
                    break@inner
                }
            }
        }
        return count
    }
}