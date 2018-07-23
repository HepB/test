package ru.lyubimov.test.kotlin.inaction.two_fundamentals

fun main(args: Array<String>) {
    val name = if(args.size > 0) args[0] else "Kotlin"
    println("Hello, $name")
}
