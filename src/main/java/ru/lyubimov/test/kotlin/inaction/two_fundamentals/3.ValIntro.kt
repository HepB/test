package ru.lyubimov.test.kotlin.inaction.two_fundamentals

//2.1.3 Переменные
val question: String = "The Ultimate Question of Life, the Universe, and Everything"
val answer: Int = 42
var a = 1

fun changeA(b: Int) {
    if (b > a) a = b
}
//Не скомпилится
//fun cantChangeAnswer(b: Int) {
//   if (b > answer) answer = b
//}

val message = if(question.length > answer) "More" else "Less"