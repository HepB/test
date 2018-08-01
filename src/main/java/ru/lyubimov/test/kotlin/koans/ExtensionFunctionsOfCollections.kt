package ru.lyubimov.test.kotlin.koans

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    arrayList.sortDescending()
    return arrayList
}