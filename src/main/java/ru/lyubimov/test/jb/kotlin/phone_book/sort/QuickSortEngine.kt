package ru.lyubimov.test.jb.kotlin.phone_book.sort

class QuickSortEngine: SortEngine {

    override fun sort(what: MutableList<String>): MutableList<String> {
        if (what.size < 2) {
            return what
        }
        val pivot = what[what.size / 2]

        val equal = what.filter { it == pivot }.toMutableList()
        val less = what.filter { it < pivot }.toMutableList()
        val greater = what.filter { it > pivot }.toMutableList()

        return (sort(less) + equal + sort(greater)).toMutableList()
    }
}