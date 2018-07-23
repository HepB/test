package ru.lyubimov.test.kotlin.inaction.two_fundamentals

import java.util.*

class Person(
        val name: String,
        var isMarried : Boolean)

//2.2.2 Собственные методы доступа
class Rectangle(val height : Int, val width : Int) {
    val isSquare : Boolean
    get() = height == width
    val diag : Int
    get() = height * width / 2
}

//2.2.3 Пакеты
fun createRandomRectangle() : Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}