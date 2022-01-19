package ru.lyubimov.test.jb.kotlin.phone_book.search

import java.io.File

class SimpleInFileEngine(private val where: File) {

    fun countOfMatches(what: File): Pair<Int, Int> {
        var count = 0
        var countOfSearchLines = 0
        what.forEachLine { stringWhatFind ->
            countOfSearchLines++
            where.forEachLine { stringWhereFound -> if (stringWhereFound.contains(stringWhatFind)) count++ }
        }
        return count to countOfSearchLines
    }
}