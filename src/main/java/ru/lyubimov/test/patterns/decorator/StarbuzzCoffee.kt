package ru.lyubimov.test.patterns.decorator

fun main(args: Array<String>) {
    val espresso: Beverage = Espresso()
    println("${espresso.getDescription()} \$${espresso.cost()}")

    var darkRoast: Beverage = DarkRoast()
    darkRoast.size = Beverage.Size.VENTI
    darkRoast = Mocha(darkRoast)
    darkRoast = Mocha(darkRoast)
    darkRoast = Whip(darkRoast)
    println("${darkRoast.getDescription()} \$${darkRoast.cost()}")

    var houseBlend: Beverage = HouseBlend()
    darkRoast.size = Beverage.Size.GRANDE
    houseBlend = Soy(houseBlend)
    houseBlend = Mocha(houseBlend)
    houseBlend = Whip(houseBlend)
    println("${houseBlend.getDescription()} \$${houseBlend.cost()}")
}