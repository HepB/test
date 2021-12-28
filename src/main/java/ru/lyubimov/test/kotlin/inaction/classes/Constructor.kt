package ru.lyubimov.test.kotlin.inaction.classes

class User(val nickname: String)
//то же самое, что User
class User1 constructor(_nickname: String) {
    val nickname: String = when (_nickname) {
        "" -> "empty"
        else -> _nickname
    }
}

open class User2(nickname: String = "")
class TwitterUser(nickname: String) : User2(nickname)
class Secretive private constructor()

open class View {
    constructor(ctx: String)
    constructor(ctx: String, attr: String)
}

class MyButton : View {
    constructor(ctx: String) : this(ctx, "")
    constructor(ctx: String, attr: String) : super(ctx, attr)
}

//4.2.3 Реализация свойств, обхявленных в интерфейсах
interface User3{
    val nickname : String
}

class PrivateUser(override val nickname: String) : User3

class SubscribingUser(val email : String) : User3 {
    override val nickname : String
    get() = email.substringBefore('@')
}

class User4(val name: String) {
    var address : String = "unspecified"
    set(value: String) {
        println("""Address was changed for $name: "$field" -> "$value".""".trimIndent())
        field = value
    }
}

fun main() {
    val user4 : User4 = User4("Name")
    user4.address = "Baiburyaki"
}
