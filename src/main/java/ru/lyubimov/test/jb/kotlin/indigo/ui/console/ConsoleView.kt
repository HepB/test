package ru.lyubimov.test.jb.kotlin.indigo.ui.console

import ru.lyubimov.test.jb.kotlin.indigo.deck.Card
import ru.lyubimov.test.jb.kotlin.indigo.game.Commands
import ru.lyubimov.test.jb.kotlin.indigo.game.GameLogic
import ru.lyubimov.test.jb.kotlin.indigo.game.Player
import ru.lyubimov.test.jb.kotlin.indigo.ui.GameView

class ConsoleView(private val logic: GameLogic) : GameView {

    override fun initView(cardsOnTable: List<Card>) {
        println("Indigo Card Game")
        var command = ""
        while (true) {
            println("Play first?")
            command = (readLine() ?: "").uppercase()
            when(command) {
                Commands.YES.name, Commands.NO.name, Commands.EXIT.name -> break
                else -> continue
            }
        }
        println("Initial cards on the table: ${cardsOnTable.joinToString(" ")}")
        when (command) {
            Commands.YES.name -> logic.playerFirst()
            Commands.NO.name -> logic.computerFirst()
            Commands.EXIT.name -> exit()
        }
    }

    override fun showTableInfo(cardsOnTable: List<Card>) {
        println()
        println(if (cardsOnTable.isNotEmpty()) {
            "${cardsOnTable.size} cards on the table, and the top card is ${cardsOnTable.last()}"
        } else {
            "No cards on the table"
        })
    }

    override fun showCardsInHandInfo(cards: List<Card>) {
        val builder = StringBuilder()
        for ((index, element) in cards.withIndex()) {
            builder.append("${index + 1})$element")
            if (index < cards.lastIndex) {
                builder.append(" ")
            }
        }
        println("Cards in hand: $builder")
    }

    override fun getNumberOfCard(lastCard: Int) {
        println("Choose a card to play (1-$lastCard):")
        interaction()
    }

    override fun showOpponentInfo(card: Card) {
        println("Computer plays $card")
    }

    override fun showOpponentHand(hand: List<Card>) {
        println(hand.joinToString(" "))
    }

    override fun showWinner(name: String) {
        println("$name wins cards")
    }

    override fun showScore(playerOne: Player, playerTwo: Player) {
        val playerOneScore = playerOne.getScore()
        val playerTwoScore = playerTwo.getScore()
        println("Score: ${playerOne.name} $playerOneScore - ${playerTwo.name} $playerTwoScore")
        println("Cards: ${playerOne.name} ${playerOne.cards.size} - ${playerTwo.name} ${playerTwo.cards.size}")
        println()
    }

    override fun showFinalResult(playerOne: Player, playerTwo: Player) {
        val playerOneScore = playerOne.getScore() + if (playerOne.cards.size > playerTwo.cards.size) 3 else 0
        val playerTwoScore = playerTwo.getScore() + if (playerOne.cards.size < playerTwo.cards.size) 3 else 0
        println("Score: ${playerOne.name} $playerOneScore - ${playerTwo.name} $playerTwoScore")
        println("Cards: ${playerOne.name} ${playerOne.cards.size} - ${playerTwo.name} ${playerTwo.cards.size}")
        println()
    }

    override fun exit() {
        println("Game Over")
    }

    private fun interaction() {
        val command = readLine() ?: ""
        if (command.uppercase() == Commands.EXIT.name) {
            exit()
        } else {
            val cardNumber = try {
                command.toInt()
            } catch (e: Exception) {
                -1
            }
            logic.nextTurn(cardNumber)
        }
    }
}