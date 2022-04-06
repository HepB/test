package ru.lyubimov.test.jb.kotlin

import kotlin.concurrent.thread

fun main() {
    thread(block = {
        Thread.sleep(1500)
        println("Hello from the custom thread!")
    })
    print(2 / 0)
    println("Hello from the main thread!")
}