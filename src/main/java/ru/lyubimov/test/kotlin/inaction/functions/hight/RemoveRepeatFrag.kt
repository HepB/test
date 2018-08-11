package ru.lyubimov.test.kotlin.inaction.functions.hight

data class SiteVisit(
        val path: String,
        val duration: Double,
        val os: OS)

enum class OS {WINDOWS, LINUX, MAC, IOS, ANDROID}

val log = listOf(
        SiteVisit(path = "/", duration = 34.0, os = OS.WINDOWS),
        SiteVisit(path = "/", duration = 22.0, os = OS.MAC),
        SiteVisit(path = "/", duration = 34.0, os = OS.WINDOWS),
        SiteVisit(path = "/", duration = 34.0, os = OS.IOS),
        SiteVisit(path = "/", duration = 16.3, os = OS.ANDROID)
)

fun List<SiteVisit>.averageDurationFor(os : OS) =
        filter { it.os == os }.map(SiteVisit::duration).average()

fun List<SiteVisit>.averageDurationForH(predicate : (SiteVisit) -> Boolean) =
        filter(predicate).map(SiteVisit::duration).average()

val averageWindowsDuration = log
        .filter{it.os == OS.WINDOWS}
        .map(SiteVisit::duration)
        .average()

fun main(args: Array<String>) {
    println(averageWindowsDuration)
    println(log.averageDurationFor(OS.MAC))
    println(log.averageDurationForH { it.os in setOf(OS.ANDROID, OS.IOS) })
}