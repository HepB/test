package ru.lyubimov.test.patterns.observer

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}