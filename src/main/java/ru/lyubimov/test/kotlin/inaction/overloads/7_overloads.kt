package ru.lyubimov.test.kotlin.inaction.overloads

import java.math.BigDecimal

data class Point(val x: Int, val y: Int)
data class AnotherPoint(var x: Int, var y: Int)
class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }

}

operator fun Point.plus(o: Point): Point {
    return Point(x + o.x, y + o.y)
}

operator fun AnotherPoint.plusAssign(o : AnotherPoint) {
    x += o.x
    y += o.y
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE
//7.1 Перегрузка арифметических операторов
fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    var p2 = Point(20, 30)
    println(p1 + p2)
    p2 += Point(1, 2)

    var ap : AnotherPoint = AnotherPoint(2, 4)
    ap += AnotherPoint(1, 2)
    println(ap)

    var bd : BigDecimal = BigDecimal(3)
    println(bd)
    val personOne = Person("Катя", "Любимова")
    val personTwo = Person("Сашчка", "Любимов")
    println(personOne > personTwo)
}
