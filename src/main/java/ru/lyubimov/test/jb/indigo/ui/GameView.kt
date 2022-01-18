package ru.lyubimov.test.jb.indigo.ui

import ru.lyubimov.test.jb.indigo.deck.Card
import ru.lyubimov.test.jb.indigo.game.Player

interface GameView {

    fun initView(cardsOnTable: List<Card>)
    fun showTableInfo(cardsOnTable: List<Card>)
    fun showCardsInHandInfo(cards: List<Card>)
    fun getNumberOfCard(lastCard: Int)
    fun showOpponentInfo(card: Card)
    fun showOpponentHand(hand: List<Card>)
    fun showWinner(name: String)
    fun showScore(playerOne: Player, playerTwo: Player)
    fun showFinalResult(playerOne: Player, playerTwo: Player)
    fun exit()
}