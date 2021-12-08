package ru.lyubimov.test.gms.codewars

fun maxRot(n: Long): Long {
    val array = n.toString().toMutableList()
    val variants: MutableList<Long> = mutableListOf(n)
    with(array) {
        for (i in 0 until size) {
            val leftElement = array.removeAt(i)
            add(leftElement)
            variants.add(joinToString(separator = "", prefix = "", postfix = "").toLong())
        }
    }
    return variants.maxOrNull() ?: n
}

fun MutableList<Char>.moveLeft(): MutableList<Char> {
    val leftElement = removeAt(0)
    add(leftElement)
    return this
}

fun main() {
    val char = mutableListOf('a', 'b', 'c', 'd')
    println(char.moveLeft().moveLeft().moveLeft().moveLeft())
    println(char)
}