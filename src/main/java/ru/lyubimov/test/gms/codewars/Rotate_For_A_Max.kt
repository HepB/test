package ru.lyubimov.test.gms.codewars

fun maxRot(n: Long): Long {
    val sb = StringBuilder()
    n.toString().toMutableList().apply { sort() }.apply { reverse() }.forEach{sb.append(it)}
    return sb.toString().toLong()
}

fun main(args: Array<String>) {
    println(maxRot(3413983))
}