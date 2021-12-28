package ru.lyubimov.test.kotlin.inaction.overloads

import java.math.BigDecimal
import java.time.LocalDate

data class Point(val x: Int, val y: Int)
data class MutablePoint(var x: Int, var y: Int)
data class Rectangle(val lowerLeft: Point, val upperRight: Point)
class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }

}

//Point
operator fun Point.plus(o: Point): Point {
    return Point(x + o.x, y + o.y)
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException()
    }
}

//MutablePoint
operator fun MutablePoint.plusAssign(o: MutablePoint) {
    x += o.x
    y += o.y
}

operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException()
    }
}

//Rectangle
operator fun Rectangle.contains(o: Point): Boolean = o.x in lowerLeft.x..upperRight.x && o.y in lowerLeft.y..upperRight.y

operator fun BigDecimal.inc() = this + BigDecimal.ONE

//7.3.4
operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start
            override fun hasNext(): Boolean =
                    current <= endInclusive

            override fun next(): LocalDate = current.apply {
                current = plusDays(1)
            }
        }

fun printEntries(map: Map<String, String>) {
    for((key, value) in map) {
        println("$key -> $value")
    }
}

fun main() {
    val p1 = Point(2, 2)
    var p2 = Point(20, 30)
    println(p1 + p2)
    p2 += Point(1, 2)

    val ap = MutablePoint(2, 4)
    ap += MutablePoint(1, 2)
    println(ap)

    val bd = BigDecimal(3)
    println(bd)
    val personOne = Person("Катя", "Любимова")
    val personTwo = Person("Сашчка", "Любимов")
    println(personOne > personTwo)

    val mp = MutablePoint(10, 20)
    mp[0] = 1
    println(mp)

    val rect = Rectangle(Point(1, 1), Point(4, 4))
    println(p1 in rect)
    println(p2 in rect)

    val map = mapOf("Катя" to "Красоточка", "Саша" to "Огрообразие")
    map.get("s")
    printEntries(map)
}
