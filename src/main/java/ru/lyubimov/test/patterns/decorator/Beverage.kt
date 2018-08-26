package ru.lyubimov.test.patterns.decorator

abstract class Beverage {
    var size: Size = Size.TAll
    enum class Size{TAll, GRANDE, VENTI}
    open fun getDescription() = "Unknown Description"
    abstract fun cost(): Double
}


class Espresso: Beverage() {
    override fun getDescription(): String = "Espresso"
    override fun cost(): Double = (when(size) {
        Size.TAll -> 1.99
        Size.GRANDE -> 2.21
        Size.VENTI -> 2.45
    })
}

class HouseBlend: Beverage() {
    override fun getDescription(): String = "House Blend Coffee"
    override fun cost(): Double = when(size) {
        Size.TAll -> 0.89
        Size.GRANDE -> 1.01
        Size.VENTI -> 1.23
    }
}

class DarkRoast: Beverage() {
    override fun getDescription(): String = "Dark Roast"
    override fun cost(): Double = when(size) {
        Size.TAll -> 1.30
        Size.GRANDE -> 1.45
        Size.VENTI -> 1.60
    }
}

class Decaf: Beverage() {
    override fun getDescription(): String = "Decaf"
    override fun cost(): Double  = when(size) {
        Size.TAll -> 2.05
        Size.GRANDE -> 2.38
        Size.VENTI -> 2.78
    }
}