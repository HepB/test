package ru.lyubimov.test.kotlin.koans

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other : MyDate): Int {
        if(year != other.year) return Integer.compare(year, other.year)
        if(month != other.month) return Integer.compare(month, other.month)
        return(Integer.compare(dayOfMonth, other.dayOfMonth))
    }
}

fun compare(date1: MyDate, date2: MyDate) = date1 < date2