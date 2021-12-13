package ru.lyubimov.test.temp

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

const val TYPE = "png"

fun main() {
    /*fizzbuzz(1, 100) { number ->
        if (number % 15 == 0) {
            return@fizzbuzz "fizzbuzz"
        }
        if (number % 3 == 0) {
            return@fizzbuzz "fizz"
        }
        if (number % 5 == 0) {
            return@fizzbuzz "buzz"
        }
        number.toString()
    }

    val coordinates = mutableListOf(
        4.0 to 4.0,
        3.0 to 2.0,
        2.0 to 4.0,
        3.0 to 4.0,
        4.0 to 2.0,
        2.0 to 2.0
    )

    val point = 3.14 to 2.7
    val distance = sqrt(2.0)
    println(findNearestCoordinates(coordinates, point, distance))

    listOf(
        Distance2D(2.0 to -2.0, -2.0 to 1.0),
        Distance2D(1.0 to 1.0, 1.0 to 6.0),
        Distance2D(0.0 to 0.0, 4.0 to 3.0),
        Distance2D(-2.0 to -1.0, -5.0 to 6.0)
    ).onEach { println("$it, dist: ${it.distance}") }

    println(parseCardNumber("1234 5678 9012 3456"))

    longestSequence()

    println(checkFilePath("test/small.png"))
    println(checkFilePath("sd f.png"))*/
    temp()
}

fun fizzbuzz(from: Int, to: Int, transformation: (Int) -> String) {
    for (number in from..to) {
        println(transformation(number))
    }
}

fun findNearestCoordinates(
    coordinates: List<Pair<Double, Double>>,
    point: Pair<Double, Double>,
    distance: Double
): List<Pair<Double, Double>> {
    return coordinates.filter { sqrt((point.first - it.first).pow(2) + (point.second - it.second).pow(2)) < distance }
}

fun parseCardNumber(cardNumber: String): Long {
    checkNumber(cardNumber)
    return prepareNumber(cardNumber)
}

fun checkNumber(cardNumber: String) {
    if (cardNumber.split(" ").size != 4) {
        throw Exception("Card number must have 3 spaces.")
    }
    val filteredCardNumber = cardNumber.filter { it != ' ' }
    filteredCardNumber.forEach {
        if (!it.isDigit()) throw Exception("You have to use a digits only.")
    }
    if (filteredCardNumber.toLong() / 1000_0000_0000_0000 < 1) {
        throw Exception("Card number must have only 16 digits")
    }
}

// for valid cardNumber only
fun prepareNumber(cardNumber: String): Long {
    return cardNumber.filter { it != ' ' }.toLong()
}

fun longestSequence() {
    // write your code here
    //val count = readLine()!!.toInt()

    val input = listOf(1, 2, 4, 1, 2, 2, 5, 7, 4, 3)

    var currentSequence = 0
    var longestSequence = 0
    var prevNumber: Int? = null

    for (currentNumber in input) {
        //val currentNumber = readLine()!!.toInt()
        when {
            prevNumber == null -> {
                prevNumber = currentNumber
                currentSequence++
                longestSequence++
                continue
            }
            currentNumber >= prevNumber -> {
                currentSequence++
            }
            longestSequence >= currentSequence -> {
                currentSequence = 1
            }
            else -> {
                longestSequence = currentSequence
                currentSequence = 1
            }
        }
        prevNumber = currentNumber
    }

    val result = if (currentSequence > longestSequence) currentSequence else longestSequence
    println(result)
}

fun temp() {
    val count = readLine()!!.toInt()
    val numbers = List(count) { readLine()!!.toInt() }
    val (at, bt) = readLine()!!.split(" ")
    val a = at.toInt()
    val b = bt.toInt()

    var isOccurNextEachOther = false

    for (i in numbers.indices) {
        val number = numbers[i]
        val haveNextElement = numbers.size - i > 1

        when {
            number == a && haveNextElement -> isOccurNextEachOther = b == numbers[i + 1]
            number == b && haveNextElement -> isOccurNextEachOther = a == numbers[i + 1]
        }
        if (isOccurNextEachOther) break
    }

    val result = if (isOccurNextEachOther) "YES" else "NO"
    println(result)
}

fun checkFilePath(path: String): String? {
    val regex = Regex(".+[.]$TYPE$")
    return if (path.matches(regex)) null else "Enter correct file path"
}

data class Distance2D(
    val firstPoint: Pair<Double, Double>,
    val secondPoint: Pair<Double, Double>
) {
    val distance = sqrt((firstPoint.first - secondPoint.first).pow(2) + (firstPoint.second - secondPoint.second).pow(2))
}