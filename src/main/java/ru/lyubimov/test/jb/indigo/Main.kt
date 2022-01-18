package ru.lyubimov.test.jb.indigo

import ru.lyubimov.test.jb.indigo.game.GameLogic
import ru.lyubimov.test.jb.indigo.game.SimpleGameLogic
import ru.lyubimov.test.jb.indigo.ui.GameView
import indigo.ui.console.ConsoleView

fun main() {
    val logic: GameLogic = SimpleGameLogic()
    val view: GameView = ConsoleView(logic)
    logic.view = view
    logic.startGame()
}
