package ru.lyubimov.test.jb.kotlin.cryptography.logic

enum class Command {
    HIDE, SHOW, EXIT, UNKNOWN;

    companion object {
        fun getCommandByName(name: String?): Command {
            return when(name?.uppercase()) {
                HIDE.name -> HIDE
                SHOW.name -> SHOW
                EXIT.name -> EXIT
                else -> UNKNOWN
            }
        }
    }
}