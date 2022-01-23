package ru.lyubimov.test.jb.kotlin

import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    // write your code here
    val array = "29 28 27 24 23 20 19 18 16 14 13 12 11 10 9 8 5 3 2 0".split(" ").map { it.toInt() }
    val needFind = "0 6 7 9 19 22 23 25 28 29".split(" ").map { it.toInt() }
    val result = needFind.map { get(it, array) }
    println(sqrt(98.0).toInt())
    println(result.joinToString(" "))
}
//19 -1 15 -1 10 -1 3 2 1 0
fun get(whatFind: Int, whereFind: List<Int>): Int {
    if (whereFind.isEmpty()) return -1
    if (whereFind[whereFind.lastIndex] == whatFind) return whereFind.lastIndex

    val step = floor(whereFind.size.toDouble()).toInt()
    var lastStepIndex = whereFind.lastIndex //8

    for (i in whereFind.lastIndex downTo 0 step step) {
        if (whatFind > whereFind[i]) {
            lastStepIndex = i //5
            continue
        } else if (whatFind == whereFind[i]) {
            return i
        } else {
            for (j in i + 1 until lastStepIndex) {
                if (whereFind[j] == whatFind) return j
            }
            return -1
        }
    }

    for (i in 0 until lastStepIndex) {
        if (whatFind == whereFind[i]) return i
    }

    return -1
}