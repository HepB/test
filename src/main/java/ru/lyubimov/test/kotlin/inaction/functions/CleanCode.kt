package ru.lyubimov.test.kotlin.inaction.functions

class User(val id: Int, val name: String, val address: String)

//3.6 Чистим код: локальные функции и расширения
internal fun saveUser(user: User) {
    fun validate(value: String,
                 fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty ${fieldName}")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun User.validateBeforeSave() {
    fun validate(value: String,
                 fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}
