package ru.lyubimov.test.patterns.fabric

abstract class Pizza(
        var name: String,
        var pizzaIngredientsFactory: PizzaIngredientsFactory
) {
    var dough: Dough? = null
    var sauce: Sauce? = null
    var cheese: Cheese? = null
    var veggies: Array<Veggies>? = null
    var pepperoni: Pepperoni? = null
    var clams: Clams? = null

    abstract fun prepare()
    fun bake() = println("Bake for 25 minutes at 350")
    fun cut() = println("Cutting the pizza into diagonal slices")
    fun box() = println("Place pizza in official PizzaStore box")

    override fun toString(): String {
        return "$name is contains: $dough, $sauce, $veggies, $pepperoni, $clams"
    }
}

class CheesePizza(
        name: String = "CheesePizza",
        pizzaIngredientsFactory: PizzaIngredientsFactory
): Pizza(name, pizzaIngredientsFactory) {

    override fun prepare() {
        println("Prepairing $name")
        dough = pizzaIngredientsFactory.createDough()
        sauce = pizzaIngredientsFactory.createSauce()
        cheese = pizzaIngredientsFactory.createCheese()
    }
}

class PepperoniPizza(
        name: String = "PepperoniPizza",
        pizzaIngredientsFactory: PizzaIngredientsFactory
): Pizza(name, pizzaIngredientsFactory) {

    override fun prepare() {
        println("Prepairing $name")
        dough = pizzaIngredientsFactory.createDough()
        sauce = pizzaIngredientsFactory.createSauce()
        pepperoni = pizzaIngredientsFactory.createPepperoni()
    }
}

class ClamPizza(
        name: String = "ClamPizza",
        pizzaIngredientsFactory: PizzaIngredientsFactory
): Pizza(name, pizzaIngredientsFactory) {

    override fun prepare() {
        println("Prepairing $name")
        dough = pizzaIngredientsFactory.createDough()
        sauce = pizzaIngredientsFactory.createSauce()
        clams = pizzaIngredientsFactory.createClam()
    }
}

class VeggiePizza(
        name: String = "VeggiePizza",
        pizzaIngredientsFactory: PizzaIngredientsFactory
): Pizza(name, pizzaIngredientsFactory) {

    override fun prepare() {
        println("Prepairing $name")
        dough = pizzaIngredientsFactory.createDough()
        sauce = pizzaIngredientsFactory.createSauce()
        clams = pizzaIngredientsFactory.createClam()
        veggies = pizzaIngredientsFactory.createVeggies()
    }
}