package ru.lyubimov.test.patterns.strategy

import ru.lyubimov.test.patterns.strategy.behavior.FlyRocketPowered
import ru.lyubimov.test.patterns.strategy.ducks.MallardDuck
import ru.lyubimov.test.patterns.strategy.ducks.RedheadDuck
import ru.lyubimov.test.patterns.strategy.ducks.RubberDuck

fun main() {
    val firstDuck = RedheadDuck()
    val secondDuck = MallardDuck()
    val thirdDuck = RubberDuck()

    firstDuck.display()
    firstDuck.performFly()
    firstDuck.performQuack()
    firstDuck.swim()
    println()

    secondDuck.display()
    secondDuck.performFly()
    secondDuck.performQuack()
    secondDuck.swim()
    secondDuck.flyBehavior = FlyRocketPowered()
    secondDuck.performFly()
    println()

    thirdDuck.display()
    thirdDuck.performFly()
    thirdDuck.performQuack()
    thirdDuck.swim()

}