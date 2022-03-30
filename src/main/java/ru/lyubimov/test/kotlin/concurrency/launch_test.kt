package ru.lyubimov.test.kotlin.concurrency

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    println("Starting")
    val importantJob = GlobalScope.launch {
        doLotsOfWorkWithFile("important_file") // waits for 5s
        println("Important file processed")    // will only print after 5s
    }
    val notImportantJob = GlobalScope.launch {
        doLotsOfWorkWithFile("optional_file")  // also waits
        println("Optional file processed")
    }

    println("Finishing")
}                                              // exits immediately, not waiting for background jobs