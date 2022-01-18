package ru.lyubimov.test.jb.indigo.game

import ru.lyubimov.test.jb.indigo.deck.Card
import ru.lyubimov.test.jb.indigo.deck.CardDesk

class Computer(
    private val hand: CardDesk,
    override val name: String = "Computer",
    override var isFirstTurn: Boolean = false,
) : Player {

    private val deck: CardDesk = CardDesk.createEmptyCardDeck()

    override val cardsInHand: List<Card>
        get() = hand.cards

    override val cards: List<Card>
        get() = deck.cards

    override fun addCards(cards: List<Card>) {
        deck.cards.addAll(cards)
    }

    override fun getCard(numberOfCard: Int): Card {
        return hand.cards.removeAt(numberOfCard - 1)
    }

    override fun takeCardsInHand(cards: List<Card>) {
        hand.cards.addAll(cards)
    }
}