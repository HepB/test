package ru.lyubimov.test.jb.kotlin

class QuizBox<T>(_item: T) {
    var isChanged = false
    var item: T = _item

        // implement methods
        get() {
            println("You asked for the item")
            return field
        }

        set(value) {
            field = value
            isChanged = true
            println("You changed the item")
        }
}