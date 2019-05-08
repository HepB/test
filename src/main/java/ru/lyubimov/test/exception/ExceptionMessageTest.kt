package ru.lyubimov.test.exception

import java.lang.Exception
import java.lang.NullPointerException

fun main(args: Array<String>) {
    getTitleTest(NullPointerException("asd sadf"))
}

fun getTitleTest(exception: Exception) {
    val errorClassName = exception::class.java.name.substringAfterLast(
            delimiter = ".",
            missingDelimiterValue = "")
    print(errorClassName)

}