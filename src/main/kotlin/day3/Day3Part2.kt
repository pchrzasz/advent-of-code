package day3

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

private const val PATH_TO_INPUT_FILE = "/day3/input.txt"

fun main() {
    val path = { }.javaClass.getResource(PATH_TO_INPUT_FILE)!!.path
    val file = File(path)
    BufferedReader(FileReader(file)).use { br ->
        var line: String?
        var sum = 0;
        var index = 0
        var elvesList = mutableListOf<String>()
        while (br.readLine().also { line = it } != null) {
            index++
            line?.let { elvesList.add(it) }
            if (index == 3) {
                elvesList.map { it.toCharArray().toMutableSet() }
                    .foldIndexed(mutableSetOf<Char>()) { idx, acc, set ->
                        if (idx == 0) {
                            acc.addAll(set)
                        } else {
                            acc.retainAll(set)
                        }
                        acc
                    }.first().also { sum += itemPriority(it) }
                index = 0
                elvesList = mutableListOf()
            }

        }
        println("Result (part2): $sum")
    }
}

fun itemPriority(sharedItem: Char): Int = if (sharedItem.isUpperCase()) sharedItem.code - 38 else sharedItem.code - 96

