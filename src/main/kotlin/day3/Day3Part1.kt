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
        while (br.readLine().also { line = it } != null) {
            val firstCompartment = line!!.substring(0, line!!.length / 2).toCharArray()
            val secondCompartment = line!!.substring(line!!.length / 2).toCharArray()
            val shared = firstCompartment.toSet().toMutableSet()
            shared.retainAll(secondCompartment.toSet())
            val sharedItem = shared.first()
            if (sharedItem.isUpperCase()) {
                sum += shared.first().code - 38
            } else if (sharedItem.isLowerCase()) {
                sum += shared.first().code - 96
            }
        }
        println("Result (part1): $sum")
    }
}