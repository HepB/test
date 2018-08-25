package ru.lyubimov.test.patterns.observer

import java.util.Observable
import java.util.Observer

class NewWeatherData: Observable() {
    var temperature: Float = 0f
    var humidity: Float = 0f
    var pressure: Float = 0f

    fun measurementsChanged() {
        setChanged()
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}

class NewCurrentConditionDisplay(private val observable: Observable): Observer, DisplayElement {
    init {
        observable.addObserver(this)
    }
    private var temperature: Float = 0f
    private var humidity: Float = 0f

    override fun display() {
        println("Temperature is $temperature, humidity is $humidity")
    }

    override fun update(observable: Observable, obj: Any?) {
        if (observable is NewWeatherData) {
            this.temperature = observable.temperature
            this.humidity = observable.humidity
            display()
        }
    }
}

class ForecastDisplay(private val observable: Observable) : Observer, DisplayElement{
    init {
        observable.addObserver(this)
    }
    var currentPressure = 29.92f
    var lastPressure = 0f

    override fun update(o: Observable?, arg: Any?) {
        if(o is NewWeatherData) {
            lastPressure = currentPressure
            currentPressure = o.pressure
            display()
        }
    }

    override fun display() {
        println("Last pressure: $lastPressure and current pressure is $currentPressure")
    }

}

fun main(args: Array<String>) {
    val wd = NewWeatherData()
    val obs = NewCurrentConditionDisplay(wd)
    val anotherObs = ForecastDisplay(wd)
    wd.setMeasurements(12f, 13f, 14f)
}