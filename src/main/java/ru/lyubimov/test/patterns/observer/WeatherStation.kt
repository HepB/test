package ru.lyubimov.test.patterns.observer

fun main(args: Array<String>) {
    val subject = WeatherData()
    val displayElement = CurrentConditionToday(subject)
    subject.setMeasurements(temperature = 11f, humidity = 221f, pressure = 700f)
    subject.setMeasurements(temperature = 12f, humidity = 222f, pressure = 701f)
}