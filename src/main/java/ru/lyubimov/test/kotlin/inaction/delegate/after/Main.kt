package ru.lyubimov.test.kotlin.inaction.delegate.after

import java.beans.PropertyChangeListener

fun main() {
    val p = Person("Dmitry", 34, 2000)
    p.addPropertyChangeListener ( PropertyChangeListener {  event ->
        println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")})
    p.age = 35
    p.salary = 2200
}