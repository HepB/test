package ru.lyubimov.test.kotlin.inaction.functions

//3.5
fun parsePath(path : String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val name = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $name, extension: $extension")
}

fun main(args: Array<String>) {
    parsePath("/users/alex/b/rotor.txt")
}