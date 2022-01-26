package ru.lyubimov.test.jb

import java.io.File

const val FILE_NAME = "hyperskill-dataset-53466252"
const val FILE_PATH = "C:\\Users\\dr_ku\\Downloads\\$FILE_NAME.txt"

fun main() {
    printCountOfLoops()
}

fun getDataLines(): List<String> = File(FILE_PATH).readLines()
fun getFirstDataSet(lines: List<String>): List<Int> = lines.first().split(" ").map { it.toInt() }

// https://hyperskill.org/learn/step/13809
fun printBinarySearchCountOfIterations() {
    val dataLines = getDataLines()
    val firstDataSet = getFirstDataSet(dataLines)
    val whatToFind = firstDataSet[6]
    println(binarySearchCountOfIterations(whatToFind, firstDataSet).first)
}

// https://hyperskill.org/learn/step/16625
fun printCountOfLoops() {
    val dataSet = "10, 15, 18, 21, 22, 23, 27, 29, 30, 36, 52, 55, 56, 66, 69, 71, 75, 79, 81, 88, 93".split(", ").map { it.toInt() }
    var result = 0
    for (element in dataSet) {
        result += binarySearchCountOfIterations(element, dataSet).first
    }
    println(result)
}

fun binarySearchCountOfIterations(what: Int, where: List<Int>): Pair<Int, Int> {
    var iteration = 0
    var index = -1
    var left = 0
    var right = where.lastIndex

    while (left <= right) {
        iteration++
        val middle = (left + right) / 2
        val element = where[middle]
        if (what == element) {
            index = element
            break
        } else if (what < element) {
            right = middle - 1
        } else {
            left = middle + 1
        }
    }
    return iteration to index
}
