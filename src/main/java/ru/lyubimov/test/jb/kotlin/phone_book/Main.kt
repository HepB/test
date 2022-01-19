package ru.lyubimov.test.jb.kotlin.phone_book

import ru.lyubimov.test.jb.kotlin.phone_book.file.getFile
import ru.lyubimov.test.jb.kotlin.phone_book.search.SimpleInFileEngine
import ru.lyubimov.test.jb.kotlin.phone_book.time.TimeUtils

const val URL_DIRECTORY = "small_directory.txt"
const val URL_FIND = "small_find.txt"

fun main() {
    val directory = URL_DIRECTORY.getFile()
    val query = URL_FIND.getFile()
    val engine = SimpleInFileEngine(directory)

    val startTime = System.currentTimeMillis()
    println("Start searching...")
    val countOfMatches = engine.countOfMatches(query)
    val difference = System.currentTimeMillis() - startTime

    val formattedTime = TimeUtils.getTimeAsMessage(difference)

    val message = "Found ${countOfMatches.first} / ${countOfMatches.second}. Time taken: $formattedTime"
    println(message)
}
