package ru.lyubimov.test.jb.kotlin.cryptography.ui

import ru.lyubimov.test.jb.kotlin.cryptography.logic.Command
import ru.lyubimov.test.jb.kotlin.cryptography.logic.Logic

class ConsoleView(private val logic: Logic) {

    fun startProgramLoop() {
        while (true) {
            println("Task (hide, show, exit):")
            val command = readLine()
            try {
                when (Command.getCommandByName(command)) {
                    Command.EXIT -> logic.exit()
                    Command.HIDE -> hide()
                    Command.SHOW -> getMessage()
                    Command.UNKNOWN -> println("Wrong task: $command")
                }
            } catch (ex: Exception) {
                println(ex.message)
            }
        }
    }

    private fun hide() {
        println("Input image file:")
        val inputFileName = readLine() ?: ""
        println("Output image file:")
        val outputFileName = readLine() ?: ""
        println("Message to hide:")
        val message = readLine() ?: ""
        val result = if (logic.hideMessageInImage(inputFileName, outputFileName, message)) {
            "Message saved in $outputFileName image."
        } else {
            "The input image is not large enough to hold this message."
        }
        println(result)
    }

    private fun getMessage() {
        println("Input image file:")
        val inputFileName = readLine() ?: ""
        val message = logic.getMessageFromImage(inputFileName)
        println("Message:\n$message")
    }
}