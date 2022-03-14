package ru.lyubimov.test.jb.kotlin.cryptography

import ru.lyubimov.test.jb.kotlin.cryptography.logic.CryptoLogic
import ru.lyubimov.test.jb.kotlin.cryptography.logic.Logic
import ru.lyubimov.test.jb.kotlin.cryptography.logic.SimpleCryptoLogic
import ru.lyubimov.test.jb.kotlin.cryptography.logic.SimpleLogic
import ru.lyubimov.test.jb.kotlin.cryptography.ui.ConsoleView

fun main() {
    val cryptoLogic: CryptoLogic = SimpleCryptoLogic()
    val logic: Logic = SimpleLogic(cryptoLogic)
    val consoleView = ConsoleView(logic)
    consoleView.startProgramLoop()
}

