package ru.lyubimov.test.kotlin.koans

import java.util.*
import kotlin.Comparator

fun getListFirst(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object : Comparator<Int>{
        override fun compare(o1: Int, o2: Int): Int {
            return Integer.compare(o2, o2)
        }
    })
    return arrayList
}