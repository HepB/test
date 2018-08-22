package ru.lyubimov.test.patterns.strategy.behavior

interface FlyBehavior {
    fun fly()
}

class FlyNoWay: FlyBehavior {
    override fun fly() {
        println("I cant fly.")
    }
}

class FlyWithWings: FlyBehavior {
    override fun fly() {
        println("Fly with wings!")
    }
}

class FlyRocketPowered: FlyBehavior {
    override fun fly() {
        println("I'm flying with rocket!!")
    }
}