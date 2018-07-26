package ru.lyubimov.test.kotlin.inaction.fundamentals

//2.3.5 Автоматическое приведение типов
interface Expr
class Num(val value: Int) : Expr
class Sum(val left : Expr, val right : Expr) : Expr

fun eval(e : Expr) : Int {
    if(e is Num) {
        return e.value
    } else if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expresion")
}

fun betterEval(e: Expr) = when(e){
    is Num -> e.value
    is Sum -> eval(e.left) + eval(e.right)
    else -> throw IllegalArgumentException("Unknown expresion")
}

fun betterEvalWithLogging(e : Expr) : Int =
        when(e) {
            is Num -> {
                println("num: ${e.value}")
                e.value}
            is Sum -> {
                val left = betterEvalWithLogging(e.left)
                val right = betterEvalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown expresion")
        }

fun main(args: Array<String>) {
    println(betterEvalWithLogging(Sum(Num(3), Sum(Num(4), Num(2)))))
}
