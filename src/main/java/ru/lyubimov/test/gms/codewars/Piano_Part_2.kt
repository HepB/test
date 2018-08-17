package ru.lyubimov.test.gms.codewars

fun whichNote(keyPressCount: Int): String =
        when (keyPressCount % 88) {
            0 -> "C"
            else -> when (keyPressCount % 88 % 12) {
                0 -> "G#"
                1 -> "A"
                2 -> "A#"
                3 -> "B"
                4 -> "C"
                5 -> "C#"
                6 -> "D"
                7 -> "D#"
                8 -> "E"
                9 -> "F"
                10 -> "F#"
                11 -> "G"
                else -> ""
            }
        }

fun main(args: Array<String>) {
    println(whichNote(89))
}