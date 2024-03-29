package ru.lyubimov.test.kotlin.koans

fun main() {

}

fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    if (client == null || message == null) return
    val personalInfo = client.personalInfo ?: return
    val email = personalInfo.email ?: return
    mailer.sendMessage(email, message)
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}