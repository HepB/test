package ru.lyubimov.test.jb.kotlin

import java.lang.Exception

fun main() {
    val line = "82 + a - -22 (21 + (4+17))"
    val elements = lineToWords(line)
    val nextElements = lineToElements(line.replace(" ", ""))
    println(elements.map { it.trim() }.filter { it.isNotEmpty() })
    println(nextElements)
    val s = listOf("a", "b", "c")
    when("a") {
        in s -> println("yes")
        else -> println("no")
    }
}

fun lineToWords(line: String): List<String> {
    val operands = line.split("\\w+".toRegex())
    val values = line.split("[-+()*/]+".toRegex())
    return values + operands
}

private fun lineToElements(line: String): MutableList<String> {
    val result = mutableListOf<String>()
    var prevChar: Char? = null
    val elementBuilder = StringBuilder()
    for ((index, char) in line.withIndex()) {
        if (prevChar == null) {
            when {
                char.isPlusOperand() || char.isMinusOperand() || char.isLetterOrDigit() -> {
                    elementBuilder.append(char)
                    prevChar = char
                }
                char.isLeftBracket() -> {
                    result.add(char.toString())
                }
                else -> throw Exception("ljl")
            }
        } else {
            when {
                char.isLeftBracket() -> {
                    result.add(elementBuilder.toString())
                    result.add(char.toString())
                    elementBuilder.clear()
                    prevChar = null
                }
                char.isRightBracket() -> {
                    result.add(elementBuilder.toString())
                    result.add(char.toString())
                    elementBuilder.clear()
                    prevChar = Char.MIN_VALUE
                }

                prevChar.isLetterOrDigit() && char.isLetterOrDigit()
                        || prevChar.isPlusOperand() && char.isPlusOperand()
                        || prevChar.isMinusOperand() && char.isMinusOperand()
                        || prevChar == Char.MIN_VALUE -> {
                    prevChar = char
                    elementBuilder.append(char)
                }
                prevChar.isLetterOrDigit() && char.isOperand()
                        || prevChar.isOperand() && char.isLetterOrDigit() -> {
                    prevChar = char
                    result.add(elementBuilder.toString())
                    elementBuilder.clear()
                    elementBuilder.append(char)
                }
                else -> throw Exception("ldf")
            }
        }
        if (index == line.lastIndex) {
            result.add(elementBuilder.toString())
            elementBuilder.clear()
        }
    }
    return result.filter { it.isNotEmpty() }.toMutableList()
}