package ru.lyubimov.test.jb.kotlin.indigo

import ru.lyubimov.test.jb.kotlin.indigo.game.GameLogic
import ru.lyubimov.test.jb.kotlin.indigo.game.SimpleGameLogic
import ru.lyubimov.test.jb.kotlin.indigo.ui.GameView
import ru.lyubimov.test.jb.kotlin.indigo.ui.console.ConsoleView

fun main() {
    val logic: GameLogic = SimpleGameLogic()
    val view: GameView = ConsoleView(logic)
    logic.view = view
    logic.startGame()
}
