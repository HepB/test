package ru.lyubimov.test.patterns.fabric

fun main() {
    val nyPizzaStore: PizzaStore = NYPizzaStore()
    val chicagoPizzaStore: PizzaStore = ChicagoPizzaStore()
    val californiaStore: PizzaStore = CaliforniaPizzaStore()

    nyPizzaStore.orderPizza("cheese")
    chicagoPizzaStore.orderPizza("cheese")
    californiaStore.orderPizza("cheese")
}