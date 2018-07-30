package ru.lyubimov.test.kotlin

open class A() {
    var name : String = "default"
    var surname : String = "default"
    constructor(name : String) : this() {
        this.name = name
    }
    constructor(name: String, surname : String) : this() {
        this.name = name
        this.surname = surname
    }
}

class B(val familyName: String) : A()