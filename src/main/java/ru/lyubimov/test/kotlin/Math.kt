package ru.lyubimov.test.kotlin

import java.util.*
import kotlin.math.pow

fun main() {
    val range = 1..900000
    resolveMathTask(range) { newNumber, number -> newNumber / 2 == number}
}

fun resolveMathTask(range: IntRange, theory: (newNumber: Int, number: Int) -> Boolean) {
    for (number in range) {
        val digits = number.extractDigits()
        val newNumber = digits.calculateNewNumber()
        if(theory.invoke(newNumber, number) && newNumber % 2 == 0) {
            println(number)
        }
    }
}

fun Int.extractDigits() : Queue<Int> {
    val temporaryString = this.toString()
    val result: LinkedList<Int> = LinkedList()
    temporaryString.forEach { result.add(it.toString().toInt()) }
    return result
}

fun Queue<Int>.calculateNewNumber(): Int {
    var result = 0
    this.forEachIndexed {index, it ->
        result += (it + index + 1) * 10.toDouble().pow(this.size - index - 1).toInt()
    }
    return result

}
