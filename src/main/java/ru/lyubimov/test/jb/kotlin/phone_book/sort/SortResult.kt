package ru.lyubimov.test.jb.kotlin.phone_book.sort

import ru.lyubimov.test.jb.kotlin.phone_book.time.EventTimeResult

data class SortResult(
    val sortedList: List<String>,
    val isSuccess: Boolean,
    override val time: Long
) : EventTimeResult
