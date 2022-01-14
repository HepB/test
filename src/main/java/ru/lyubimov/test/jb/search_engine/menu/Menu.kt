package ru.lyubimov.test.jb.search_engine.menu

import ru.lyubimov.test.jb.search_engine.ext.toInvertedIndexMap
import ru.lyubimov.test.jb.search_engine.engine.ConsoleSearchProcessor

class Menu(private val data: List<String>) {

    //keys in uppercase
    private val invertedIndexData: Map<String, List<Int>> = data.toInvertedIndexMap()

    init {
        processMenu()
    }

    private fun processMenu() {
        while(true) {
            when(selectMenuItem()) {
                1 -> {
                    println()
                    ConsoleSearchProcessor.find(invertedIndexData, data)
                    println()
                }
                2 -> {
                    println()
                    ConsoleSearchProcessor.printAllLines(data)
                    println()
                }
                0 -> {
                    println("Bye")
                    return
                }
                else -> {
                    println()
                    println("Incorrect option! Try again.")
                    println()
                }
            }
        }
    }

    private fun selectMenuItem(): Int {
        showMenu()
        return getMenuNumber()
    }

    private fun showMenu() {
        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")
    }

    private fun getMenuNumber(): Int {
        var number = -1
        try {
            number = readLine()?.toInt() ?: -1
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return number
    }
}