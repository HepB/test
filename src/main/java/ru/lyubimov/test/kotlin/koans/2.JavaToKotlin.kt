package ru.lyubimov.test.kotlin.koans

fun toJSON(collection: Collection<Int>): String {
    val sb = StringBuilder()
    sb.append("[")
    for((index, element) in collection.withIndex()) {
        if(index < collection.size - 1) sb.append("$element, ")
        else sb.append(element)
    }
    sb.append("]")
    return sb.toString()
}