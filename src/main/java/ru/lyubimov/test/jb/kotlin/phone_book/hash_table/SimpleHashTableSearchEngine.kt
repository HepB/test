package ru.lyubimov.test.jb.kotlin.phone_book.hash_table

class SimpleHashTableSearchEngine(private val where: SimpleHashTable<String>) {

    fun search(what: List<String>): Int {
        var result = 0
        what.forEach { result += where.contains(it) }
        return result
    }
}