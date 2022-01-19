package ru.lyubimov.test.jb.kotlin.indigo.game

import ru.lyubimov.test.jb.kotlin.indigo.deck.Card
import ru.lyubimov.test.jb.kotlin.indigo.deck.CardDesk

class Table(private val cardDesk: CardDesk): CardsHolder {

    fun getCardsFromDesk(): List<Card> {
        val result = cardDesk.cards.toList()
        cardDesk.cards.clear()
        return result
    }

    fun getTopCard() = cardDesk.cards.lastOrNull()

    override fun addCards(cards: List<Card>) {
        cardDesk.cards.addAll(cards)
    }

    override val cards: List<Card>
        get() = cardDesk.cards
}