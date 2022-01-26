package ru.lyubimov.test.jb.kotlin.phone_book.hash_table

import ru.lyubimov.test.jb.kotlin.phone_book.time.EventTimeResult

data class CreateHashTableResult(
    val result: SimpleHashTable<String>,
    override val time: Long
) : EventTimeResult
