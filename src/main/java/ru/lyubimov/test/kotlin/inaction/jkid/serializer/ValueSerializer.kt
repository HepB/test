package ru.lyubimov.test.kotlin.inaction.jkid.serializer

interface ValueSerializer<T> {
    fun toJsonValue(value: T): Any?
    fun fromJsonValue(jsonValue : Any?) : T
}