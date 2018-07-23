package ru.lyubimov.test.kotlin.inaction.two_fundamentals

fun main(args: Array<String>) {
    print(max(21, 23))
}
//2.1.2 Функции
fun max(a: Int, b: Int) : Int {
    return if (a > b) a else b
}

fun maxNoBody(a: Int, b: Int) =
        if(a > b) a else b


