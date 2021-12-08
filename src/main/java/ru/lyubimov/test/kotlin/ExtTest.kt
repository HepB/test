package ru.lyubimov.test.kotlin


fun String.prepareUrl(valuesForMustaches: Map<String, String>?): String {
    if (valuesForMustaches == null || valuesForMustaches.isEmpty()) return this
    var result = this
    valuesForMustaches.forEach { (key, value) ->
        result = result.replace(
            oldValue = key,
            newValue = value,
            ignoreCase = true
        )
    }
    result = result.replace(Regex("\\{\\{.*?}}"), "")
    return result
}

fun main() {
    val valuesForMustaches = mapOf(
        Pair("{{CONTRACTOR_CATEGORY_ID}}", "3:3"),
        Pair("{{INSTANT_RAND_U32INT}}", "2032003265"),
        Pair("{{AF_LPDID}}", "54958:9575"),
        Pair("{{CONTRACTOR_EPISODE_ID}}", "1:1"),
        Pair("{{AD_VID}}", "096c50ed-2c7c-4391-8b84-5054d4416f77"),
        Pair("{{CONTRACTOR_PROJECT_ID}}", "819628"),
        Pair("{{ADFOX_EID3}}", "dvtp:3:adid:1ce00bd0-35c3-42df-83ee-2a330cf5c28d:advid:096c50ed-2c7c-4391-8b84-5054d4416f77:mac:020000000000"),
        Pair("{{SESSION_ID}}", "16304162779581611760002"),
        Pair("{{CONTRACTOR_SEASON_ID}}", "48436"),
    )
    val url = "https://ads.adfox.ru/264443/event?hash=fc83966faecfbc91&rand=blegdyu&pm=e&sj=BQUBHkQ6AMb-6uEhK5E7us98W7dIsqopzoEk3a-vywIo29YiV4LEqQwGHoPkNz_x3y2m2QcBcHrXVGKg6q_Q2RuFr79y4XY0bzxq1j7Zlw%3D%3D&utg=oxum<s=ezccgey&eid1=%24%24%24eid1%24%24%24&puid6=1069&puid5=24455&puid19=1&puid1=283&pr=a&p1=bzhdx&p2=fuki&puid7=1&p5=ftbrh&puid9=1&puid12=186080&puid3=187683&puid16=92&rqs=XuSoIAcAAABop2lbE8Kk-AOuOdj62QLm&puid21=0&puid10=1&puid22=ctc.ru&puid11=187643&puid2=229103&puid20=0&puid13=186102&puid15=0&aaa={{AD_VID}}"
    print(url.prepareUrl(valuesForMustaches))
}
