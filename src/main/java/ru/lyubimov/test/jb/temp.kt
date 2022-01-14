package ru.lyubimov.test.temp

fun main() {
    fibonacci()
    val first = readLine()!!
    val second = readLine()!!
    println(first.equals(second, true))
    val array: ArrayList<String>
}

open class Facility(val floors: Byte) {
    fun addFloors(num: Byte): Int = floors + num
}

open class Factory(floors: Byte, val employees: Short, val roof: Byte) : Facility(floors) {
    fun buildRoof(): Int = super.addFloors(roof)
    open fun employeesPerFloor(): Int = employees / floors
}

open class FactoryWithRoof(floors: Byte, roof: Byte, employees: Short) : Factory(floors, employees, roof) {
    override fun employeesPerFloor(): Int = employees / (floors + super.buildRoof())
}

fun fibonacci() {
    var prev = 0
    var current = 1
    for (i in 0..24) {
        val swap = prev
        prev = current
        current += swap
        println(current)
    }
}