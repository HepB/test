package ru.lyubimov.test.kotlin.inaction.lambda

fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")

    val responces = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responces)
}

fun printMessagesWithPrefix(messages: Collection<String>, prefix : String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responces : Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responces.forEach{
        if(it.startsWith("4")){
            clientErrors++
        } else if(it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}