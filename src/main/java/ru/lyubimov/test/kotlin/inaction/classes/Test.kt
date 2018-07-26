package ru.lyubimov.test.kotlin.inaction.classes

import ru.lyubimov.test.kotlin.inaction.functions.User
import ru.lyubimov.test.kotlin.inaction.functions.saveUser

fun main(args: Array<String>) {
    val button = Button()
    button.click()
    button.setFocus(true)
    button.showOff()

    val user = User(id = 1, name = "two", address = "three")
    saveUser(user)
}