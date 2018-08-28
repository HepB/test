package ru.lyubimov.test.patterns.fabric

interface PizzaIngredientsFactory {
    fun createDough(): Dough
    fun createSauce(): Sauce
    fun createCheese(): Cheese
    fun createVeggies(): Array<Veggies>
    fun createPepperoni(): Pepperoni
    fun createClam(): Clams
}

class NYPizzaIngredientFactory: PizzaIngredientsFactory {
    override fun createPepperoni(): Pepperoni = SlicedPepperoni()
    override fun createDough(): Dough = ThinCrustDough()
    override fun createSauce(): Sauce = MarinaraSauce()
    override fun createCheese(): Cheese = ReggianoCheese()
    override fun createVeggies(): Array<Veggies> = arrayOf(Garlic(), Onion(), Mushroom(), RedPepper())
    override fun createClam(): Clams = FreshClams()
}

class ChicagoPizzaIngredientFactory: PizzaIngredientsFactory {
    override fun createPepperoni(): Pepperoni = FreshPepperoni()
    override fun createDough(): Dough = FatCheeseDough()
    override fun createSauce(): Sauce = CheeseSauce()
    override fun createCheese(): Cheese = BelebeiCheese()
    override fun createVeggies(): Array<Veggies> = arrayOf(Garlic(), Onion(), Mushroom(), Pepper())
    override fun createClam(): Clams = FrozenClams()
}

class CaliforniaPizzaIngredientFactory: PizzaIngredientsFactory {
    override fun createPepperoni(): Pepperoni = CrazyPepperoni()
    override fun createDough(): Dough = ThinCrustDough()
    override fun createSauce(): Sauce = CheeseSauce()
    override fun createCheese(): Cheese = BelebeiCheese()
    override fun createVeggies(): Array<Veggies> = arrayOf(Garlic(), Onion(), Mushroom(), Pepper(), Petrushka())
    override fun createClam(): Clams = FreshClams()
}