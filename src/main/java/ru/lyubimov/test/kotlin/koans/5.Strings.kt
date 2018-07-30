package ru.lyubimov.test.kotlin.koans

import java.text.SimpleDateFormat
import java.util.*

val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

fun getPattern(): String = """\d{2}\ ${month} \d{4}"""
