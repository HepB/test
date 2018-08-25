package ru.lyubimov.test.patterns.observer

interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

class WeatherData: Subject  {

    private val observers: MutableList<Observer> = mutableListOf()
    private var temperature: Float = 0f
    private var humidity: Float = 0f
    private var pressure: Float = 0f

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(humidity = humidity, pressure = pressure, temp = temperature)
        }
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measureChanged()
    }

    fun measureChanged() = notifyObservers()
}