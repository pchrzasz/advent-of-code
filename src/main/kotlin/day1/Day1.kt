package day1

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

private const val PATH_TO_INPUT_FILE = "/day1/file.txt"

fun main() {
    val path = { }.javaClass.getResource(PATH_TO_INPUT_FILE)!!.path
    val file = File(path)
    BufferedReader(FileReader(file)).use { br ->
        var line: String?
        var sum = 0
        var max = 0
        while (br.readLine().also { line = it } != null) {
            if (line.isNullOrBlank()) {
                max = if (sum > max) sum else max
                sum = 0
            } else {
                sum += line!!.toInt()
            }
        }
        println("Max: $max")
    }

}
