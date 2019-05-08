package ru.lyubimov.test.kotlin.damir

import java.util.stream.Stream
import kotlin.streams.toList

fun main() {
    val firstClasses = listOf(
            FirstClass("A1"),
            FirstClass("B1"),
            FirstClass("C1"))

    val secondClasses = listOf(
            SecondClass("A2"),
            SecondClass("B2"),
            SecondClass("C2")
    )

    val thirdClasses = listOf(
            ThirdClass("A3"),
            ThirdClass("B3"),
            ThirdClass("C3")
    )


    val result = Stream.of(
            firstClasses.map { it.fieldF },
            secondClasses.map { it.fieldS },
            thirdClasses.map { it.fieldT }
    ).flatMap { it.stream() }.toList()

    println(result)
}