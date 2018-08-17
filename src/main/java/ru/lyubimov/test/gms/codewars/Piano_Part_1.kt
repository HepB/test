package ru.lyubimov.test.gms.codewars

const val BLACK = "black"
const val WHITE = "white"

fun blackOrWhiteKey(keyPressCount: Int): String = when {
    (keyPressCount / 88).isEven() -> when (keyPressCount % 88) {
        2, 5, 7, 10, 12, 14, 17, 19, 22, 24, 26, 29, 31, 34, 36, 38,
        41, 43, 46, 48, 50, 53, 55, 58, 60, 62, 65, 67, 70, 72, 74,
        77, 79, 82, 84, 86 -> BLACK
        else -> WHITE
    }
    (keyPressCount / 88).isOdd() -> when (keyPressCount % 88) {
        3, 5, 7, 10, 12, 15, 17, 19, 22, 24, 27, 29, 31, 34, 36, 39,
        41, 43, 46, 48, 51, 53, 55, 58, 60, 63, 65, 67, 70, 72, 75, 77, 79,
        82, 84, 87 -> BLACK
        else -> WHITE
    }
    else -> throw Exception("WTF exception")
}

fun Int.isEven(): Boolean = this % 2 == 0
fun Int.isOdd(): Boolean = this % 2 > 0

fun main(args: Array<String>) {
    println(blackOrWhiteKey(92))
    println((176 + 1)/88)
}