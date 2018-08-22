package ru.lyubimov.test.patterns.strategy.ducks

import ru.lyubimov.test.patterns.strategy.behavior.*

abstract class Duck(var flyBehavior: FlyBehavior, var quackBehavior: QuackBehavior) {

    fun performQuack() = quackBehavior.quack()
    fun performFly() = flyBehavior.fly()
    fun display() = println("${this::class.simpleName} displays.")
    fun swim() = println("${this::class.simpleName} swims.")
}

class DecoyDuck: Duck(flyBehavior = FlyNoWay(), quackBehavior = Quack())
class MallardDuck : Duck(flyBehavior = FlyWithWings(), quackBehavior = Quack())
class ModelDuck: Duck(flyBehavior = FlyNoWay(), quackBehavior = MuteQuack())
class RedheadDuck : Duck(flyBehavior = FlyWithWings(), quackBehavior = Quack())
class RubberDuck: Duck(flyBehavior = FlyNoWay(), quackBehavior = Squeack())