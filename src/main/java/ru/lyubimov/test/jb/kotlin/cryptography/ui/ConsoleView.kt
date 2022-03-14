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
        val inputFileName = readInputFileName()
        val outputFileName = readOutputFileName()
        val message = readMessage()
        val password = readPassword()
        val result = if (logic.hideMessageInImage(inputFileName, outputFileName, message, password)) {
            "Message saved in $outputFileName image."
        } else {
            "The input image is not large enough to hold this message."
        }
        println(result)
    }

    private fun getMessage() {
        val inputFileName = readInputFileName()
        val password = readPassword()
        val message = logic.getMessageFromImage(inputFileName, password)
        println("Message:\n$message")
    }

    private fun readInputFileName(): String {
        println("Input image file:")
        return readLine() ?: ""
    }

    private fun readOutputFileName(): String {
        println("Output image file:")
        return readLine() ?: ""
    }

    private fun readMessage(): String {
        println("Message to hide:")
        return readLine() ?: ""
    }

    private fun readPassword(): String {
        println("Password:")
        return readLine() ?: ""
    }
}