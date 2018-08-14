package ru.lyubimov.test.kotlin.inaction.jkid

import ru.lyubimov.test.kotlin.inaction.jkid.annotation.DeserializeInterface
import ru.lyubimov.test.kotlin.inaction.jkid.annotation.JsonExclude
import ru.lyubimov.test.kotlin.inaction.jkid.annotation.JsonName

data class Person(
        @JsonName("alias") val name: String,
        @JsonExclude val age: Int? = null,
        @DeserializeInterface(CompanyImpl::class) val company: Company)