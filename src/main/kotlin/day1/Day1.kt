package day1

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.*

private const val PATH_TO_INPUT_FILE = "/day1/file.txt"

fun main() {
    val path = { }.javaClass.getResource(PATH_TO_INPUT_FILE)!!.path
    val file = File(path)
    val topThree = TopThree()
    BufferedReader(FileReader(file)).use { br ->
        var line: String?
        var sum = 0
        var max = 0
        while (br.readLine().also { line = it } != null) {
            if (line.isNullOrBlank()) {
                max = if (sum > max) sum else max
                topThree.put(sum)
                sum = 0
            } else {
                sum += line!!.toInt()
            }
        }
        println("Max: $max")
        println("Sum top three: ${topThree.sum()}")
    }
}

class TopThree : PriorityQueue<Int>() {
    fun put(num: Int) {
        add(num)
        if (size > 3) poll()
    }

    fun sum() = this.toList().sum()

}