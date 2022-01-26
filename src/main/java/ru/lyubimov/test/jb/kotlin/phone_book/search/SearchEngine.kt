package ru.lyubimov.test.jb.kotlin.phone_book.search

interface SearchEngine {
    fun search(what: List<String>): Int
}