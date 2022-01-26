package ru.lyubimov.test.jb.kotlin.phone_book.sort

class FakeBubbleSortEngine: SortEngine {

    override fun sort(what: MutableList<String>): MutableList<String> {
        Thread.sleep(60 * 1000)
        what.sort()
        return what
    }
}