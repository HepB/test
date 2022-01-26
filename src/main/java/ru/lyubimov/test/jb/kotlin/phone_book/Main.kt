package ru.lyubimov.test.jb.kotlin.phone_book

import ru.lyubimov.test.jb.kotlin.phone_book.file.getFile
import ru.lyubimov.test.jb.kotlin.phone_book.file.linesWithoutPhone
import ru.lyubimov.test.jb.kotlin.phone_book.hash_table.CreateHashTableResult
import ru.lyubimov.test.jb.kotlin.phone_book.hash_table.SimpleHashTable
import ru.lyubimov.test.jb.kotlin.phone_book.hash_table.SimpleHashTableSearchEngine
import ru.lyubimov.test.jb.kotlin.phone_book.time.EventTimeResult
import ru.lyubimov.test.jb.kotlin.phone_book.time.TimeUtils
import ru.lyubimov.test.jb.kotlin.phone_book.search.*
import ru.lyubimov.test.jb.kotlin.phone_book.sort.*

const val URL_DIRECTORY = "C:\\directory.txt"
const val URL_FIND = "C:\\find.txt"

fun main() {
    val directory = URL_DIRECTORY.getFile()
    val query = URL_FIND.getFile()
    val where = directory.linesWithoutPhone()
    val what = query.readLines()

    linearSearchStep(what, where)
    println()

    //        _ _,---._
    //       ,-','       `-.___
    //      /-;'               `._
    //     /\/          ._   _,'o \
    //    ( /\       _,--'\,','"`. )
    //     |\      ,'o     \'    //\
    //     |      \        /   ,--'""`-.
    //     :       \_    _/ ,-'         `-._
    //      \        `--'  /                )
    //       `.  \`._    ,'     ________,','
    //         .--`     ,'  ,--` __\___,;'
    //          \`.,-- ,' ,`_)--'  /`.,'
    //           \( ;  | | )      (`-/
    //             `--'| |)       |-/
    //               | | |        | |
    //               | | |,.,-.   | |_
    //               | `./ /   )---`  )
    //              _|  /    ,',   ,-'
    //     -hrr-   ,'|_(    /-<._,' |--,
    //             |    `--'---.     \/ \
    //             |          / \    /\  \
    //           ,-^---._     |  \  /  \  \
    //        ,-'        \----'   \/    \--`.
    //       /            \              \   \
    // jumpSearchStep(what, where.toMutableList())
    // println()

    fakeJumpSearchStep(what, where.toMutableList())
    println()

    binarySearchStep(what, where.toMutableList())
    println()

    hashTableSearchStep(what, where)
}

fun linearSearchStep(what: List<String>, where: List<String>) {
    println("Start searching (linear search)...")
    val linearSearchEngine = LinearSearchEngine(where)
    val linearSearchResult = makeSearch(what, linearSearchEngine)
    printResult(linearSearchResult, null)
}

fun jumpSearchStep(what: List<String>, where: MutableList<String>) {
    println("Start searching (bubble sort + jump search)...")
    val sortEngine = BubbleSortEngine()
    val sortResult = makeSort(where, sortEngine)
    val searchEngine = JumpSearchEngine(sortResult.sortedList)
    val searchResult = makeSearch(what, searchEngine)
    printResult(searchResult, sortResult)
}

fun fakeJumpSearchStep(what: List<String>, where: MutableList<String>) {
    println("Start searching (bubble sort + jump search)...")
    val sortEngine = FakeBubbleSortEngine()
    val sortResult = makeSort(where, sortEngine)
    val searchEngine = JumpSearchEngine(sortResult.sortedList)
    val searchResult = makeSearch(what, searchEngine)
    printResult(searchResult, sortResult)
}

fun binarySearchStep(what: List<String>, where: MutableList<String>) {
    println("Start searching (quick sort + binary search)...")
    val sortEngine = QuickSortEngine()
    val sortResult = makeSort(where, sortEngine)
    val searchEngine = BinarySearchEngine(sortResult.sortedList)
    val searchResult = makeSearch(what, searchEngine)
    printResult(searchResult, sortResult)
}

fun hashTableSearchStep(what: List<String>, where: MutableList<String>) {
    println("Start searching (hash table)...")
    val createHashTableResult = makeHashTable(where)
    val engine = SimpleHashTableSearchEngine(createHashTableResult.result)
    val searchResult = searchInHashTable(engine, what)
    printResult(searchResult, createHashTableResult, "Creating")
}

fun makeSearch(what: List<String>, engine: SearchEngine): SearchResult {
    val startTime = System.currentTimeMillis()
    val countOfMatches = engine.search(what)
    return SearchResult(
        entries = countOfMatches,
        allLines = what.size,
        time = System.currentTimeMillis() - startTime
    )
}

fun makeSort(what: MutableList<String>, sortEngine: SortEngine): SortResult {
    val startTime = System.currentTimeMillis()
    val sorted = sortEngine.sort(what)
    return SortResult(
        sortedList = sorted,
        isSuccess = true,
        time = System.currentTimeMillis() - startTime
    )
}

fun makeHashTable(what: List<String>): CreateHashTableResult {
    val startTime = System.currentTimeMillis()
    val hashTable = SimpleHashTable(what)
    return CreateHashTableResult(
        result = hashTable,
        time = System.currentTimeMillis() - startTime
    )
}

fun searchInHashTable(engine: SimpleHashTableSearchEngine, what: List<String>): SearchResult {
    val startTime = System.currentTimeMillis()
    val countOfMatches = engine.search(what)
    return SearchResult(
        allLines = what.size,
        entries = countOfMatches,
        time = System.currentTimeMillis() - startTime
    )
}

private fun printResult(searchResult: SearchResult, sortResult: EventTimeResult?, message: String = "Sorting") {
    val formattedTime = TimeUtils.getTimeAsMessage(searchResult.time + (sortResult?.time ?: 0L))
    val simpleSearchMessage =
        "Found ${searchResult.entries} / ${searchResult.allLines}. Time taken: $formattedTime"
    println(simpleSearchMessage)
    if (sortResult != null) {
        println("$message time: ${TimeUtils.getTimeAsMessage(sortResult.time)}")
        println("Searching time: ${TimeUtils.getTimeAsMessage(searchResult.time)}")
    }
}

