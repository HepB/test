package ru.lyubimov.test.jb.kotlin

fun Char.isPlusOperand(): Boolean = this == '+'
fun Char.isMinusOperand(): Boolean = this == '-'
fun Char.isDivideOperand(): Boolean = this == '/'
fun Char.isMultipleOperand(): Boolean = this == '*'
fun Char.isLeftBracket(): Boolean = this == '('
fun Char.isRightBracket(): Boolean = this == ')'
fun Char.isOperand(): Boolean = isPlusOperand() || isMinusOperand() || isDivideOperand() || isMultipleOperand()
        || isLeftBracket() || isRightBracket()