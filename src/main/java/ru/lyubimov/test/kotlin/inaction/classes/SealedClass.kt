package ru.lyubimov.test.kotlin.inaction.classes

sealed class Expr{
    class Num(val value : Int) : Expr()
    class Sum(val left : Expr, val right : Expr) : Expr()
}

fun eval(e: Expr) : Int =
        when(e) {
            is Expr.Num -> e.value
            is Expr.Sum -> eval(e.right) + eval(e.left)
        }