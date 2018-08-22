package ru.lyubimov.test.patterns.strategy.behavior

interface QuackBehavior {
    fun quack()
}

class MuteQuack: QuackBehavior{
    override fun quack() {
        println("There is no sound.")
    }

}

class Quack: QuackBehavior {
    override fun quack() {
        println("Quack")
    }
}

class Squeack: QuackBehavior {
    override fun quack() {
        println("Squeack")
    }

}