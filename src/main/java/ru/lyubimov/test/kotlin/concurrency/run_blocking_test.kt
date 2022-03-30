package ru.lyubimov.test.kotlin.concurrency

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun doLotsOfWorkWithFile(file: String) = delay(5_000)

fun main() {
    runBlocking {                      // this lambda is our root suspending function
        println("Starting coroutine.") // it can contain regular functions
        doLotsOfWorkWithFile("a")      // and suspending functions as well
    }
    println("Work is done!")
}