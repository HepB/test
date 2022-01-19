package ru.lyubimov.test.jb.kotlin.indigo.game

import ru.lyubimov.test.jb.kotlin.indigo.deck.Card

interface CardsHolder {
    val cards: List<Card>
    fun addCards(cards: List<Card>)
}