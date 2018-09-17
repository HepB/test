package ru.lyubimov.test.gms.codingame

import java.util.*

fun main(args : Array<String>) {
    val input = Scanner(System.`in`)
    val n = input.nextInt() // the number of temperatures to analyse
    var min = if(n == 0) 0 else 5526
    for (i in 0 until n) {
        val t = input.nextInt() // a temperature expressed as an integer ranging from -273 to 5526
    }

    // Write an action using println()
    // To debug: System.err.println("Debug messages...");

    println("result")
}

fun convertToPositive(i: Int): Int = if (i < 0) i * -1 else i