package ru.lyubimov.test.kotlin.koans

fun joinOptions(options: Collection<String>) = options.joinToString(separator = ", ", prefix = "[", postfix = "]")