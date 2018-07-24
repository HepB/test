package ru.lyubimov.test.kotlin.inaction.three_fun

import ru.lyubimov.test.kotlin.inaction.three_fun.strings.joinToString

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

fun main(args: Array<String>) {
    println(map.values)
    println(set.last())
    println(list.shuffle())
    println(list.min())
    println(list)

    val collection = arrayListOf("Раз", "Два", "Три")
    println(joinToString(collection, separator = ",", postfix = ">", prefix = "<"))
    println(joinToString(collection, prefix = "<"))
}
