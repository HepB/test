package ru.lyubimov.test.jb.indigo.game

import ru.lyubimov.test.jb.indigo.deck.Card

interface CardsHolder {
    val cards: List<Card>
    fun addCards(cards: List<Card>)
}