package ru.lyubimov.test.jb.kotlin.phone_book.time

object TimeUtils {
    fun getTimeAsMessage(mills: Long): String {
        val seconds = mills / 1000
        val ms = mills % 1000
        val s: Long = seconds % 60
        val m: Long = seconds / 60 % 60
        return String.format("%d min. %d sec. %d ms.", m, s, ms)
    }
}