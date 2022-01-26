package ru.lyubimov.test.jb.kotlin.phone_book.search

import ru.lyubimov.test.jb.kotlin.phone_book.time.EventTimeResult

data class SearchResult(
    val entries: Int,
    val allLines: Int,
    override val time: Long
) : EventTimeResult
