package ru.lyubimov.test.patterns.fabric

abstract class PizzaStore() {

    fun orderPizza(type: String): Pizza? {
        val pizza: Pizza = createPizza(type) ?: throw NullPointerException("What do you say?")
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }

    protected abstract fun createPizza(type: String): Pizza?
}

class NYPizzaStore(): PizzaStore() {

    override fun createPizza(type: String): Pizza? {
        val pizzaIngredientsFactory = NYPizzaIngredientFactory()
        return when(type) {
            "cheese" -> CheesePizza("New York cheese pizza", pizzaIngredientsFactory)
            "veggie" -> VeggiePizza("New York veggie pizza", pizzaIngredientsFactory)
            "calm" -> ClamPizza( "New York calm pizza", pizzaIngredientsFactory)
            "pepperoni" -> PepperoniPizza("New York pepperoni pizza", pizzaIngredientsFactory)
            else -> null
        }
    }
}

class ChicagoPizzaStore(): PizzaStore() {
    override fun createPizza(type: String): Pizza? {
        val pizzaIngredientsFactory = ChicagoPizzaIngredientFactory()
        return when(type) {
            "cheese" -> CheesePizza("Chicago pizza", pizzaIngredientsFactory)
            "veggie" -> VeggiePizza("Chicago veggie pizza", pizzaIngredientsFactory)
            "calm" -> ClamPizza( "Chicago calm pizza", pizzaIngredientsFactory)
            "pepperoni" -> PepperoniPizza("Chicago pepperoni pizza", pizzaIngredientsFactory)
            else -> null
        }
    }
}

class CaliforniaPizzaStore(): PizzaStore() {
    override fun createPizza(type: String): Pizza? {
        val pizzaIngredientsFactory = CaliforniaPizzaIngredientFactory()
        return when(type) {
            "cheese" -> CheesePizza("California pizza", pizzaIngredientsFactory)
            "veggie" -> VeggiePizza("California veggie pizza", pizzaIngredientsFactory)
            "calm" -> ClamPizza( "CCalifornia calm pizza", pizzaIngredientsFactory)
            "pepperoni" -> PepperoniPizza("California pepperoni pizza", pizzaIngredientsFactory)
            else -> null
        }
    }
}