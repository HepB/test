package ru.lyubimov.test.jb.kotlin.phone_book.search

import kotlin.math.sqrt

class JumpSearchEngine(private val sortedWhere: List<String>): SearchEngine {

    override fun search(what: List<String>): Int {
        var count = 0
        what.forEach { count += contains(it) }
        return count
    }

    private fun contains(what: String): Int {
        val step = sqrt(sortedWhere.size.toDouble()).toInt()
        var prevIndex = 0
        for (i in 0.. sortedWhere.lastIndex step step) {
            if (what > sortedWhere[i]) {
                prevIndex = i
                continue
            } else if (what == sortedWhere[i]) {
                return 1
            }
            else {
                for (j in i downTo prevIndex) {
                    if (what == sortedWhere[j]) return 1
                }
            }
            prevIndex = i
        }
        for (i in sortedWhere.lastIndex downTo prevIndex - 1) {
            if (what == sortedWhere[i]) return 1
        }
        return 0
    }
}