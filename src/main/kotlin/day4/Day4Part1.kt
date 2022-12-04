package day4

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

private const val PATH_TO_INPUT_FILE = "/day4/input.txt"

fun main() {
    val path = { }.javaClass.getResource(PATH_TO_INPUT_FILE)!!.path
    val file = File(path)
    BufferedReader(FileReader(file)).use { br ->
        var line: String?
        var sum = 0;
        while (br.readLine().also { line = it } != null) {
            val ranges = line!!.substringBefore(",").asIntRange() to line!!.substringAfter(",").asIntRange()
//            if(ranges.first.fullyOverlaps(ranges.second) || ranges.second.fullyOverlaps(ranges.first)) sum++
            if (ranges.first.overlaps(ranges.second) || ranges.second.overlaps(ranges.first)) sum++
        }
        println("Result (part1): $sum")
    }
}

private fun String.asIntRange(): IntRange =
    substringBefore("-").toInt()..substringAfter("-").toInt()

private fun IntRange.fullyOverlaps(other: IntRange): Boolean =
    first <= other.first && last >= other.last

private fun IntRange.overlaps(other: IntRange): Boolean =
    first <= other.last && other.first <= last