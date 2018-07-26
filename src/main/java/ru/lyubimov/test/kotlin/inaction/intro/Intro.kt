package ru.lyubimov.test.kotlin.inaction.intro

//1.1 первое знакомство с Kotlin
data class Person(val name :String, val age : Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alce"), Person("Bob", age = 25))
    val oldest = persons.maxBy{it.age ?: 0}
    println("The oldest is: $oldest")
}

