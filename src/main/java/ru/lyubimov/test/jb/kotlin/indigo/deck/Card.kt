package ru.lyubimov.test.jb.kotlin.indigo.deck

data class Card(val cardType: CardType, val suitType: SuitType) {
    override fun toString(): String {
        return "${cardType.type}${suitType.type}"
    }
}