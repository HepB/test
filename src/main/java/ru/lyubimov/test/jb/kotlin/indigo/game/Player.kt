package ru.lyubimov.test.jb.kotlin.indigo.game

import ru.lyubimov.test.jb.kotlin.indigo.deck.Card
import ru.lyubimov.test.jb.kotlin.indigo.deck.CardType

interface Player : CardsHolder {
    val cardsInHand: List<Card>
    val name: String
    var isFirstTurn: Boolean
    fun getCard(numberOfCard: Int): Card
    fun takeCardsInHand(cards: List<Card>)
    fun getScore(): Int {
        return cards.count {
            it.cardType == CardType.ACE || it.cardType == CardType.JACK || it.cardType == CardType.TEN || it.cardType == CardType.KING || it.cardType == CardType.QUEEN
        }
    }
}