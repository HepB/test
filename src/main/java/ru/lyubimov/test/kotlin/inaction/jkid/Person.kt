package ru.lyubimov.test.kotlin.inaction.jkid

import ru.lyubimov.test.kotlin.inaction.jkid.annotation.CustomSerializer
import ru.lyubimov.test.kotlin.inaction.jkid.annotation.DeserializeInterface
import ru.lyubimov.test.kotlin.inaction.jkid.annotation.JsonExclude
import ru.lyubimov.test.kotlin.inaction.jkid.annotation.JsonName
import ru.lyubimov.test.kotlin.inaction.jkid.serializer.DataSerializer
import java.util.*

data class Person(
        @JsonName("alias") val name: String,
        @JsonExclude val age: Int? = null,
        @DeserializeInterface(CompanyImpl::class) val company: Company,
        @CustomSerializer(DataSerializer::class) val birthDate: Date
)