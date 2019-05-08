package ru.lyubimov.test.string

fun main() {
    val testValue = "{{one}}-adsf-{{two}}-adsf"
    print(replaceTest(testValue))
}

fun replaceTest(str: String): String {
    var result = str
    val testMap = mapOf(
            Pair("{{one}}", "oNe"),
            Pair("{{two}}", "tWo")
    )
    testMap.forEach{(key, value) ->
        result = result.replace(key, value, true)
    }
    return result
}