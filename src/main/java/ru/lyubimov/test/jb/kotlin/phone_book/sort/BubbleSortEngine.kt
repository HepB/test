package ru.lyubimov.test.jb.kotlin.phone_book.sort

class BubbleSortEngine: SortEngine {

    override fun sort(what: MutableList<String>): MutableList<String> {

        var counter = what.lastIndex
        while (counter > 0) {
            var prevIndex = 0
            for (i in 1..counter) {
                if (what[prevIndex] > what[i]) {
                    val temp = what[prevIndex]
                    what[prevIndex] = what[i]
                    what[i] = temp
                }
                prevIndex = i
            }
            counter--
        }
        return what
    }
}