package ru.lyubimov.test.jb.kotlin.indigo.deck

class CardDesk private constructor() {

    var cards = mutableListOf<Card>()

    companion object {
        fun create52CardDesk(): CardDesk {
            val result = CardDesk()
            for (cardType in CardType.values()) {
                for (suitType in SuitType.values()) {
                    result.cards.add(Card(cardType, suitType))
                }
            }
            return result
        }

        fun createEmptyCardDeck(): CardDesk = CardDesk()
    }
}