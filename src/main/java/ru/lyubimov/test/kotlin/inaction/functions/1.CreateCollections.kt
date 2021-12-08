package ru.lyubimov.test.kotlin.inaction.functions

import ru.lyubimov.test.kotlin.inaction.functions.strings.joinToString

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
const val STRING_CONST: String = "word"

fun main() {
    println(map.values)
    println(set.last())
    println(list.shuffle())
    println(list.minOrNull())
    println(list)
    println(STRING_CONST.lastChar())

    val collection = arrayListOf("Раз", "Два", "Три")
    println(collection.joinToString(separator = ",", postfix = ">", prefix = "<"))
    println(collection.joinToString(prefix = "<"))
}

//3.3 Функции-расширения
fun String.lastChar(): Char = this[this.length - 1]

infix fun Any.to(other: Any) = Pair(this, other)
