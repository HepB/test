package ru.lyubimov.test.kotlin.inaction.classes

class Outer {
    inner class Inner{
        fun getOuterReference() : Outer = this@Outer
    }
}