package ru.lyubimov.test.kotlin.koans

class DateRangeFirst(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(date: MyDate): Boolean = when {
        (date >= start) && (date <= endInclusive) -> true
        else -> false
    }
}

/*fun checkInRangeFirst(date: MyDate, first: MyDate, last: MyDate): Boolean {
    return date in DateRange(first, last)
}*/

