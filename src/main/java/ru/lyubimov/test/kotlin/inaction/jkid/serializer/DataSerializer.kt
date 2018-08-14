package ru.lyubimov.test.kotlin.inaction.jkid.serializer

import java.text.SimpleDateFormat
import java.util.*

object DataSerializer: ValueSerializer<Date> {
    private val dateFormat = SimpleDateFormat("dd-mm-yyyy")

    override fun toJsonValue(value: Date): Any? = dateFormat.format(value)
    override fun fromJsonValue(jsonValue: Any?): Date = dateFormat.parse(jsonValue as String)
}