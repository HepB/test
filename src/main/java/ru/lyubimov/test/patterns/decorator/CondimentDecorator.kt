package ru.lyubimov.test.patterns.decorator

abstract class CondimentDecorator : Beverage() {
    abstract override fun getDescription(): String
}

class Mocha(private val beverage: Beverage) : CondimentDecorator() {
    override fun getDescription(): String = "${beverage.getDescription()}, Mocha"
    override fun cost(): Double = when (beverage.size) {
        Size.TAll -> beverage.cost() + 0.20
        Size.GRANDE -> beverage.cost() + 0.30
        Size.VENTI -> beverage.cost() + 0.40
    }
}

class Soy(private val beverage: Beverage) : CondimentDecorator() {
    override fun getDescription(): String = "${beverage.getDescription()}, Soy"
    override fun cost(): Double = when (beverage.size) {
        Size.TAll -> beverage.cost() + 0.33
        Size.GRANDE -> beverage.cost() + 0.44
        Size.VENTI -> beverage.cost() + 0.55
    }
}

class Whip(private val beverage: Beverage) : CondimentDecorator() {
    override fun getDescription(): String = "${beverage.getDescription()}, Whip"
    override fun cost(): Double = when (beverage.size) {
        Size.TAll -> beverage.cost() + 0.10
        Size.GRANDE -> beverage.cost() + 0.15
        Size.VENTI -> beverage.cost() + 0.20
    }
}
