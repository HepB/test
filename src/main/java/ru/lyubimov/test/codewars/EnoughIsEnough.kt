package ru.lyubimov.test.codewars

object EnoughIsEnough {
    fun deleteNth(elements:IntArray, maxOcurrences:Int):IntArray {
        val elementsMap = mutableMapOf<Int, Int>()
        return elements.filter {
            if (elementsMap.containsKey(it)) {
                elementsMap[it] = elementsMap[it]!!.plus(1)
            } else {
                elementsMap[it] = 1
            }
            elementsMap[it]!! <= maxOcurrences
        }.toIntArray()
    }
}