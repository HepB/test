package ru.lyubimov.test.jb.kotlin.phone_book.hash_table

import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

class SimpleHashTable<T>(elements: List<T>, private val loadFactor: Double = 0.75) {

    private lateinit var buckets: Array<LinkedList<T>?>

    init { addAll(elements) }

    private fun addAll(list: List<T>) {
        val bucketsSize = list.size + list.size * loadFactor
        buckets = Array(bucketsSize.roundToInt()) { null }
        for (element in list) {
            add(element)
        }
    }

    /**
     * return 1 if contains, else 0
     */
    fun contains(element: T): Int {
        val hash = hash(element, buckets.size)
        val elementInBucket = buckets[hash]
        return if (element == null || elementInBucket?.contains(element) == false) {
            0
        } else {
            1
        }
    }

    private fun add(element: T): Boolean {
        val result: Boolean
        val hash = hash(element, buckets.size)
        val currentBucket = buckets[hash]
        if (currentBucket == null) {
            buckets[hash] = LinkedList<T>().also { it.add(element) }
            result = true
        } else if (currentBucket.contains(element)) {
            result = false
        } else {
            currentBucket.add(element)
            result = true
        }
        return result
    }

    private fun hash(element: T, modulo: Int): Int = element.hashCode().absoluteValue % modulo
}
