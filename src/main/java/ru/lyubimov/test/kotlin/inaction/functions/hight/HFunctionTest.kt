package ru.lyubimov.test.kotlin.inaction.functions.hight

enum class Delivery { STANDARD, EXTENDED }
class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if(delivery == Delivery.EXTENDED) {
        return {order -> 6 + 2.1 * order.itemCount }
    }
    return {order -> 1.2 * order.itemCount }
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "",
        transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }
        val str = transform?.invoke(element) ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    twoAndThree { a, b -> a + b }
    twoAndThree { a, b -> a * b }
    println("af23dfdS2sdf".filter { it in 'a'..'z' })

    val letters = listOf("alpha", "beta", "gamma", "eta")
    println(letters.joinToString(separator = "! ", prefix = "", postfix = "!", transform = { it.toUpperCase() }))

    //8.1.5
    val calculator = getShippingCostCalculator(Delivery.EXTENDED)
    println("Shipping costs ${calculator(Order(3))}")
}