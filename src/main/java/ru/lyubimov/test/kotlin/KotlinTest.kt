package ru.lyubimov.test.kotlin

fun main(args: Array<String>) {
    println(containsValue("src_type"))
}

fun containsValue(value: String): Boolean {
    return  Mustache.values().any{ it.name.equals(value, true) }
}

