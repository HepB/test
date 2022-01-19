package ru.lyubimov.test.jb.kotlin.search_engine.input

import java.lang.Exception
import java.lang.IndexOutOfBoundsException

object InputProcessor {

    private const val ARG_FILE_PATH= "--data"

    fun readInputData(args: Array<String>): InputData {
        var inputFilePath= ""

        for (index in args.indices) {
            when (args[index]) {
                ARG_FILE_PATH -> {
                    try {
                        inputFilePath = args[index + 1]
                        break
                    } catch (ex: IndexOutOfBoundsException) {
                        throw Exception("Enter input file path")
                    }
                }
                else -> throw Exception("Incorrect argument")
            }
        }

        if (inputFilePath.isEmpty()) throw Exception("No file path argument")

        return InputData(inputFilePath)
    }
}