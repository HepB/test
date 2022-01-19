package ru.lyubimov.test.jb.kotlin.indigo.game

import ru.lyubimov.test.jb.kotlin.indigo.deck.Card
import ru.lyubimov.test.jb.kotlin.indigo.deck.CardDesk

class User(
    private val hand: CardDesk,
    override val name: String = "Player",
    override var isFirstTurn: Boolean = false,
): Player {
    private val deck: CardDesk = CardDesk.createEmptyCardDeck()

    override val cards: List<Card>
        get() = deck.cards

    override fun addCards(cards: List<Card>) {
        deck.cards.addAll(cards)
    }

    override val cardsInHand: List<Card>
        get() = hand.cards

    override fun getCard(numberOfCard: Int): Card {
        return hand.cards.removeAt(numberOfCard - 1)
    }

    override fun takeCardsInHand(cards: List<Card>) {
        hand.cards.addAll(cards)
    }
}