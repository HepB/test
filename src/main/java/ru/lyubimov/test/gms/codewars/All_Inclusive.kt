package ru.lyubimov.test.gms.codewars

fun containAllRoots(string: String, arr: ArrayList<String>): Boolean = arr.filter { string.eqaulChars(it)}.size == string.length

fun String.eqaulChars(another: String) : Boolean {
    val first = this.toList()
    val second = another.toList()
    return first.containsAll(second) && first.size == second.size
}

fun main(args: Array<String>) {
    val a = arrayListOf("asd", "dsa", "qsq", "sad", "af2")
    println(containAllRoots("asd", a))
}