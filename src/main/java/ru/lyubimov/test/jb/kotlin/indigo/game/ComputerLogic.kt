package ru.lyubimov.test.jb.kotlin.indigo.game

import ru.lyubimov.test.jb.kotlin.indigo.deck.Card
import ru.lyubimov.test.jb.kotlin.indigo.deck.CardType
import ru.lyubimov.test.jb.kotlin.indigo.deck.SuitType

class ComputerLogic(private val computer: Computer) {

    fun selectCard(table: Table): Int {
        if (computer.cardsInHand.size == 1) {
            return 1
        }
        val topCardOnTheTable = table.getTopCard()
            ?: return computer.cardsInHand.indexOf(theBestCandidate(computer.cardsInHand)) + 1
        val candidates = getCandidates(topCardOnTheTable)
        return when (candidates.size) {
            0 -> computer.cardsInHand.indexOf(theBestCandidate(computer.cardsInHand)) + 1
            1 -> computer.cardsInHand.indexOf(candidates.first()) + 1
            else -> computer.cardsInHand.indexOf(theBestCandidate(candidates)) + 1
        }
    }

    private fun getCandidates(topCard: Card): List<Card> {
        return computer.cardsInHand.filter { topCard.cardType == it.cardType || topCard.suitType == it.suitType }
    }

    private fun theBestCandidate(candidates: List<Card>): Card {
        val cardsBySuit = mutableMapOf<SuitType, Int>()
        for (suit in SuitType.values()) {
            cardsBySuit[suit] = candidates.count { it.suitType == suit }
        }
        val maxBySuitType = cardsBySuit.maxByOrNull { it.value }
        if ((maxBySuitType?.value ?: 0) > 1) {
            return candidates.filter { it.suitType == maxBySuitType?.key  }.random()
        }

        val cardsByCardType = mutableMapOf<CardType, Int>()
        for (cardType in CardType.values()) {
            cardsByCardType[cardType] = candidates.count { it.cardType == cardType }
        }
        val maxByCardType = cardsByCardType.maxByOrNull { it.value }
        if ((maxByCardType?.value ?: 0) > 1) {
            return candidates.filter { it.cardType == maxByCardType?.key  }.random()
        }

        return candidates.random()
    }
}