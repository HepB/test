package ru.lyubimov.test.jb.kotlin

import java.io.File
import kotlinx.coroutines.*
import kotlin.math.sqrt
import kotlin.math.min

private val names = File("C:\\find.txt").readLines()
private val phones = File("C:\\directory.txt").readLines().map {
    Pair(it.substring(0, it.indexOf(" ")), it.substring(it.indexOf(" ") + 1))
}

fun linearSearch(): Int {
    var entries = 0
    for (name in names) for (phone in phones)
        if (phone.second == name) {
            entries++
            break
        }
    return entries
}

suspend fun bubbleSort(): List<Pair<String, String>> {
    val sorted = phones.toMutableList()
    var isSorted = false
    while (!isSorted) {
        isSorted = true
        for (i in 0 until sorted.lastIndex)
            if (sorted[i].second > sorted[i + 1].second) {
                isSorted = false
                for (j in i until sorted.lastIndex) {
                    if (sorted[j].second < sorted[j + 1].second) break
                    sorted[j] = sorted[j + 1].also { sorted[j + 1] = sorted[j] }
                }
            }
        delay(1)
    }
    return sorted
}

fun jumpSearch(sorted: List<Pair<String, String>>): Int {
    var entries = 0
    val step = sqrt(sorted.size.toDouble()).toInt()
    for (name in names) {
        var i = 0
        while (sorted[i].second < name && i < sorted.lastIndex)
            i = min(i + step, sorted.lastIndex)
        while (sorted[i].second > name && i > 0) i--
        if (sorted[i].second == name) entries++
    }
    return entries
}

fun parseTime(time: Long) = String.format("%1\$tM min. %1\$tS sec. %1\$tL ms.", time)

suspend fun main() {
    println("Start searching (linear search)...")
    var start = System.currentTimeMillis()
    var entries = linearSearch()
    var end = System.currentTimeMillis()
    val timeout = (end - start) * 10
    println("Found $entries / ${names.size} entries. Time taken: ${parseTime(end - start)}")

    println("Start searching (bubble sort + jump search)...")
    try {
        withTimeout(timeout) {
            start = System.currentTimeMillis()
            val sorted = bubbleSort()
            val sortingEnd = System.currentTimeMillis()
            entries = jumpSearch(sorted)
            end = System.currentTimeMillis()
            println("Found $entries / ${names.size} entries. Time taken: ${parseTime(end - start)}")
            println("Sorting time: ${parseTime(sortingEnd - start)}")
            println("Searching time: ${parseTime(end - sortingEnd)}")
        }
    } catch (e: TimeoutCancellationException) {
        start = System.currentTimeMillis()
        entries = linearSearch()
        end = System.currentTimeMillis()
        println("Found $entries / ${names.size} entries. Time taken: ${parseTime(end - start + timeout)}")
        println("Sorting time: ${parseTime(timeout)}  - STOPPED, moved to linear search")
        println("Searching time: ${parseTime(end - start)}")
    }
}