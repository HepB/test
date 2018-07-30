package ru.lyubimov.test.kotlin.inaction.classes

import java.io.File

object CaseInsensitiveFileComparator: Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

class User5 private constructor(val nickname : String) {
    companion object {
        fun newSubscribingUser(email: String) =
                User5(email.substringBefore('@'))
    }
}