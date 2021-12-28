package ru.lyubimov.test.graphic.three_plus.input

import java.lang.Exception
import java.lang.IndexOutOfBoundsException

const val ARG_INPUT = "-in"
const val ARG_OUTPUT = "-out"

object InputPreprocessor {

    fun readInputData(args: Array<String>): InputData {
        var inputFilePath= ""
        var outputFilePath= ""

        for (index in args.indices step 2) {
            when (args[index]) {
                ARG_INPUT -> {
                    try {
                        inputFilePath = args[index + 1]
                    } catch (ex: IndexOutOfBoundsException) {
                        throw Exception("Enter input file path")
                    }
                }
                ARG_OUTPUT -> {
                    try {
                        outputFilePath = args[index + 1]
                    } catch (ex: IndexOutOfBoundsException) {
                        throw Exception("Enter output file path")
                    }
                }
                else -> throw Exception("Incorrect argument")
            }
        }

        return InputData(
            inputFilePath = inputFilePath,
            outputFilePath = outputFilePath
        )
    }
}