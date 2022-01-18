package ru.lyubimov.test.jb.indigo.game

import ru.lyubimov.test.jb.indigo.ui.GameView

interface GameLogic {
    var view: GameView?

    fun startGame()
    fun playerFirst()
    fun computerFirst()
    fun nextTurn(cardNumber: Int)
    fun exit()
}