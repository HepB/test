package ru.lyubimov.test.jb.kotlin

fun printXor(condition1: Int, condition2: Int) {
    println(condition1 xor condition2)
}

fun main() {
    val condition1 = 175892
    val condition2 = 98795

    val q: Int = 'q'.code


    if (condition1 and condition2 > 35925)
        printXor(condition1 - condition2, condition1 or condition2) // 1
    else {
        val a = condition1 xor condition2
        val b = condition1 and condition2
        printXor(condition1 xor condition2, condition1 and condition2) // 2\
        val c = 0
    }

}