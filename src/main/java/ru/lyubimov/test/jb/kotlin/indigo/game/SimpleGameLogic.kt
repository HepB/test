package ru.lyubimov.test.jb.kotlin.indigo.game

import ru.lyubimov.test.jb.kotlin.indigo.deck.Card
import ru.lyubimov.test.jb.kotlin.indigo.deck.CardDesk
import ru.lyubimov.test.jb.kotlin.indigo.ui.GameView

const val INITIAL_TABLE_CARDS = 4
const val PLAYER_HAND_CARDS = 6

class SimpleGameLogic(
    override var view: GameView? = null,
    private var deck: CardDesk = CardDesk.create52CardDesk(),
    private var playerOne: Player = User(CardDesk.createEmptyCardDeck()),
    private var playerTwo: Player = Computer(CardDesk.createEmptyCardDeck()),
    private var table: Table = Table(CardDesk.createEmptyCardDeck()),
    private var computerLogic: ComputerLogic = ComputerLogic(playerTwo as Computer)
) : GameLogic {

    private var whoTakeLastTime: Player? = null

    override fun startGame() {
        shuffleDeck()
        table.addCards(getCardsFromDesk(INITIAL_TABLE_CARDS))
        playerOne.takeCardsInHand(getCardsFromDesk(PLAYER_HAND_CARDS))
        playerTwo.takeCardsInHand(getCardsFromDesk(PLAYER_HAND_CARDS))
        view?.initView(table.cards)
    }

    override fun playerFirst() {
        playerOne.isFirstTurn = true
        getNextTurn()
    }

    override fun computerFirst() {
        playerOne.isFirstTurn = true
        view?.showTableInfo(table.cards)
        playerTurn(playerTwo, computerLogic.selectCard(table))
        getNextTurn()
    }

    override fun nextTurn(cardNumber: Int) {
        if (!isNumberCorrect(cardNumber)) {
            view?.getNumberOfCard(playerOne.cardsInHand.size)
            return
        }
        playerTurn(playerOne, cardNumber)
        if (isGameOver()) {
            processFinalResult()
            exit()
            return
        }
        view?.showTableInfo(table.cards)
        val compCard = computerLogic.selectCard(table)
        playerTurn(playerTwo, compCard)
        if (isGameOver()) {
            processFinalResult()
            exit()
            return
        }
        getNextTurn()
    }

    override fun exit() {
        view?.exit()
    }

    private fun processFinalResult() {
        view?.showTableInfo(table.cards)
        when {
            whoTakeLastTime == null && playerOne.isFirstTurn -> playerOne.addCards(table.getCardsFromDesk())
            whoTakeLastTime == null && playerTwo.isFirstTurn -> playerTwo.addCards(table.getCardsFromDesk())
            else -> whoTakeLastTime?.addCards(table.getCardsFromDesk())
        }
        view?.showFinalResult(playerOne, playerTwo)
    }

    private fun getNextTurn() {
        val tableInfo = table.cards
        view?.showTableInfo(tableInfo)
        view?.showCardsInHandInfo(playerOne.cardsInHand)
        view?.getNumberOfCard(playerOne.cardsInHand.size)
    }

    private fun playerTurn(player: Player, cardNumber: Int) {
        if (player is Computer) {
            view?.showOpponentHand(player.cardsInHand)
        }
        val playerCard = player.getCard(cardNumber)
        if (player is Computer) {
            view?.showOpponentInfo(playerCard)
        }
        if (checkWinCondition(playerCard)) {
            whoTakeLastTime = player
            getCards(player, playerCard, table.getCardsFromDesk())
            view?.showWinner(player.name)
            view?.showScore(playerOne, playerTwo)
        } else {
            table.addCards(listOf(playerCard))
        }
        if (player.cardsInHand.isEmpty()) {
            player.takeCardsInHand(getCardsFromDesk(PLAYER_HAND_CARDS))
        }
    }

    private fun getCardsFromDesk(count: Int): List<Card> {
        return if (count <= deck.cards.size)
            List(count) { deck.cards.removeAt(0) }
        else {
            emptyList()
        }
    }

    private fun getCards(player: Player, playedCard: Card, cardsOnTable: List<Card>) {
        player.addCards(listOf(playedCard))
        player.addCards(cardsOnTable)
    }

    private fun checkWinCondition(card: Card): Boolean {
        return card.cardType == table.cards.lastOrNull()?.cardType || card.suitType == table.cards.lastOrNull()?.suitType
    }

    private fun shuffleDeck() {
        deck.cards.shuffle()
    }

    private fun isNumberCorrect(numberOfCard: Int) = numberOfCard in 1..playerOne.cardsInHand.size
    private fun isGameOver() =
        playerOne.cardsInHand.isEmpty() && playerTwo.cardsInHand.isEmpty() && deck.cards.isEmpty()

}