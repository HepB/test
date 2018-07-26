package ru.lyubimov.test.kotlin.inaction.classes

open class RichButton : Clickable {

    final override fun click() = println("I,m was clicked")

    fun disable() {}

    open fun animate() {}
}