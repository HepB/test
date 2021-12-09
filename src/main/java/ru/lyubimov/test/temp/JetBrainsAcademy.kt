package ru.lyubimov.test.temp

import kotlin.math.pow
import kotlin.math.sqrt

fun fizzbuzz(from: Int, to: Int, transformation: (Int) -> String) {
    for (number in from..to) {
        println(transformation(number))
    }
}

fun main() {
    fizzbuzz(1, 100) { number ->
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

data class Distance2D(
    val firstPoint: Pair<Double, Double>,
    val secondPoint: Pair<Double, Double>
) {
    val distance = sqrt((firstPoint.first - secondPoint.first).pow(2) + (firstPoint.second - secondPoint.second).pow(2))
}