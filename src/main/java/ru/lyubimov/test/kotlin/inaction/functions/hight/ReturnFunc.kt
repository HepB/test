package ru.lyubimov.test.kotlin.inaction.functions.hight

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }
        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

data class Person(
        val firstName: String,
        val lastName: String,
        val phoneNumber: String?
)

fun main(args: Array<String>) {
    val contacts = listOf(Person("Dmitry", "Hitry", "123-456"),
            Person("Svetlana", "Milanova", null))
    val contactsListFilters = ContactListFilters()
    with(contactsListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactsListFilters.getPredicate()))
}
