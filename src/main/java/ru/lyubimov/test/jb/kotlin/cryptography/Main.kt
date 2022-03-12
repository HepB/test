package ru.lyubimov.test.jb.kotlin.cryptography

import ru.lyubimov.test.jb.kotlin.cryptography.logic.Logic
import ru.lyubimov.test.jb.kotlin.cryptography.logic.SimpleLogic
import ru.lyubimov.test.jb.kotlin.cryptography.ui.ConsoleView

fun main() {
    val logic: Logic = SimpleLogic()
    val consoleView = ConsoleView(logic)
    consoleView.startProgramLoop()
}

