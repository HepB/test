package ru.lyubimov.test.kotlin.inaction.types

import java.lang.IllegalArgumentException

data class Employee(val name: String, val manager: Employee?)

data class Address(val streetAddress : String, val zipCode: Int,
              val city : String, val country : String)

data class Company(val name : String, val address: Address?)

class Person(val name : String, val company : Company?) {
    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? Person ?: return false
        return otherPerson.name == name && otherPerson.company == company
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (company?.hashCode() ?: 0)
        return result
    }
}

fun main(args: Array<String>) {
    //6.1.3
    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)
    println(ceo)
    println(developer)
    //6.1.4
    val address = Address("Elsestr. 47", 80787, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Nikolay", jetbrains)
    printShippingLabel(person)
    //6.1.7
    val email: String? = "san@mail.ru"
    email?.let { sendEmail(it) }
}

fun managerName(employee: Employee) : String? = employee.manager?.name
fun sendEmail(email : String) {}

fun printShippingLabel(person: Person) {
    val address = person.company?.address ?: throw IllegalArgumentException("No address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

