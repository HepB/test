package ru.lyubimov.test.kotlin.inaction.delegate.after

import ru.lyubimov.test.kotlin.inaction.delegate.before.PropertyChangeAware

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
}