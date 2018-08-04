package ru.lyubimov.test.kotlin.inaction.overloads

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) : Point {
        return Point(x + other.x, y + other.y)
    }
}

//7.1 Перегрузка арифметических операторов
fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(20, 30)
    println(p1 + p2)
}