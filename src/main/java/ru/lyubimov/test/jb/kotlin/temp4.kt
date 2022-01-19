package ru.lyubimov.test.jb.kotlin

fun main() {
    // write your code here
    val (word, n) = readLine()!!.split(" ")
    val shift = n.toInt() % word.length
    for (i in 0..word.lastIndex) {
        if (i in 0 .. word.lastIndex - shift) {
            print(word[i + shift])
        } else {
            print(word[i - (word.length - shift)])
        }
    }
}