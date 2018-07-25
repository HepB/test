package ru.lyubimov.test.kotlin.inaction.three_fun

import ru.lyubimov.test.kotlin.inaction.three_fun.strings.joinToString

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
const val STRING_CONST: String = "word"

fun main(args: Array<String>) {
    val (number, name) = 1 to "one"
    println(map.values)
    println(set.last())
    println(list.shuffle())
    println(list.min())
    println(list)
    println(STRING_CONST.lastChar())

    val collection = arrayListOf("Раз", "Два", "Три")
    println(collection.joinToString(separator = ",", postfix = ">", prefix = "<"))
    println(collection.joinToString(prefix = "<"))
}

//3.3 Функции-расширения
fun String.lastChar(): Char = this.get(this.length - 1)

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }

infix fun Any.to(other: Any) = Pair(this, other)
