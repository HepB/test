package ru.lyubimov.test.kotlin.inaction.jkid

data class Person(
        @JsonName("alias") val name: String,
        @JsonExclude val age: Int? = null)