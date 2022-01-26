package ru.lyubimov.test.jb.kotlin.phone_book.sort

interface SortEngine {
    fun sort(what: MutableList<String>): MutableList<String>
}