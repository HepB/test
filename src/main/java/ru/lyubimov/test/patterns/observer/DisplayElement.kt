package ru.lyubimov.test.patterns.observer

interface DisplayElement {
    fun display()
}

class CurrentConditionToday(private val weatherData: Subject) : DisplayElement, Observer {

    init {
        weatherData.registerObserver(this)
    }

    private var temperature: Float = 0f
    private var humidity: Float = 0f

    override fun display() {
        println("Temperature is $temperature, humidity is $humidity")
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temp
        this.humidity = humidity
        display()
    }

}