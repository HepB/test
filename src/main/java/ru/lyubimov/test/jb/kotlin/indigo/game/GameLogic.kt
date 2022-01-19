package ru.lyubimov.test.jb.kotlin.indigo.game

import ru.lyubimov.test.jb.kotlin.indigo.ui.GameView

interface GameLogic {
    var view: GameView?

    fun startGame()
    fun playerFirst()
    fun computerFirst()
    fun nextTurn(cardNumber: Int)
    fun exit()
}