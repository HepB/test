package ru.lyubimov.test.kotlin.inaction.jkid.annotation

import ru.lyubimov.test.kotlin.inaction.jkid.serializer.ValueSerializer
import kotlin.reflect.KClass

annotation class CustomSerializer (val serializerClass : KClass<out ValueSerializer<*>>)

