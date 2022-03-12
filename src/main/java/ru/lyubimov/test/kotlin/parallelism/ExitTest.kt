package ru.lyubimov.test.kotlin.parallelism

import kotlin.system.exitProcess

fun main() {
    val thread = ExitTest()
    thread.start()
    2 / 0
    println("End of main")
}

class ExitTest: Thread() {
    override fun run() {
        super.run()
        println("In exitTest")
        //exitProcess(322)
    }
}