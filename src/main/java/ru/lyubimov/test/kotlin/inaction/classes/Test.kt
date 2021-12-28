package ru.lyubimov.test.kotlin.inaction.classes

import ru.lyubimov.test.kotlin.inaction.functions.User
import ru.lyubimov.test.kotlin.inaction.functions.saveUser

fun main() {
    val button = Button()
    button.click()
    button.setFocus(true)
    button.showOff()

    val user = User(id = 1, name = "two", address = "three")
    saveUser(user)

    val client: Client1 = Client1("name", 223)
    println(client.hashCode())
    val client2: Client1 = client.copy()
    println(client2.hashCode())
}

class Client(val name: String, val postalCode: Int) {

    override fun toString() = "Client(name='$name', postalCode=$postalCode)"
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is Client) return false
        return name != other.name && postalCode != other.postalCode
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }
}

data class Client1(val name: String, val postalCode: Int)