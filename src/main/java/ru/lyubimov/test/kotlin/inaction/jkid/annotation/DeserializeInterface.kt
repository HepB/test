package ru.lyubimov.test.kotlin.inaction.jkid.annotation

import kotlin.reflect.KClass

annotation class DeserializeInterface(val targetClass : KClass<out Any>)