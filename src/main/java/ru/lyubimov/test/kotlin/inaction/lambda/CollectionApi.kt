package ru.lyubimov.test.kotlin.inaction.lambda

data class Person(val name: String, val age: Int)
class Book(val title: String, val authors: List<String>)

val personsTwo = arrayListOf<Person>()

fun main(args: Array<String>) {
    val people = listOf(
            Person("Vasya", 31),
            Person("Kolya", 21),
            Person("Rita", 22),
            Person("Kostya", 31))
    val books = listOf(
            Book("Война и мир", listOf("Л. Н. Толстой")),
            Book("Пикник на обочине", listOf("А. Стругацкий", "Б. Стругацкий")),
            Book("Пикник на всколчине", listOf("А. Стругацкий")))
    //5.2.1
    println(people.filter { it.age < 30 })
    personsTwo.addAll(people.filter { it.age < 30 })
    println(people.map { it.name })
    println(personsTwo)

    val maxAge = people.maxBy(Person::age)!!.age
    people.filter { it.age == maxAge }

    //5.2.2
    val canBeInClub27 = { p: Person -> p.age <= 27 }
    println()
    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27))
    println()
    //5.2.3
    println(people.groupBy(Person::age))
    //5.2.4
    println(books.flatMap { it.authors }.toSet())

    //5.3 Sequnces
    println(people.asSequence().map(Person::name).filter { it.startsWith("K") }.toList())
    println(listOf(1, 2, 3, 4).asSequence()
            .map { print("map($it "); it * it }
            .filter { print("filter($it) "); it % 2 == 0 }
            .toList())
    println(listOf(1, 2, 3, 4).asSequence()
            .map { it * it }
            .filter { it > 3 }
            .find { it > 6 })
    println()

    //5.3.2
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
    println(alphabet())
    println(alphabetBuilder())
}

//5.5.1
fun alphabet(): String {
    return with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nKnow I know alphabet!")
        toString()
    }
}

//5.5.2
fun alphabetBuilder(): StringBuilder {
    return with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nKnow I know alphabet!")
    }
}