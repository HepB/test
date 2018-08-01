package ru.lyubimov.test.kotlin.inaction.lambda

data class Person(val name: String, val age: Int)
val personsTwo = arrayListOf<Person>()

fun main(args: Array<String>) {
    val persons = listOf(
            Person("Vasya", 31),
            Person("Kolya", 21),
            Person("Rita", 22),
            Person("Kolya", 31))
    //5.2.1
    println(persons.filter { it.age <30 })
    personsTwo.addAll(persons.filter { it.age <30 })
    println(persons.map { it.name })
    println(personsTwo)

    val maxAge = persons.maxBy(Person::age)!!.age
    persons.filter {it.age == maxAge}

    //5.2.2

}