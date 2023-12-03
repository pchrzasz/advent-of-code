package com.pchrzasz.aoc

class Day01 {

    fun solvePart1(input: List<String>): Int = input.sumOf { calibrationValues(it) }

    fun solvePart2(input: List<String>): Int = input.sumOf {
        calibrationValues(
            it.mapIndexedNotNull { index, c ->
                if (c.isDigit()) c
                else it.wordsAtIndex(index).firstNotNullOfOrNull { wordToDigit[it] }
            }.joinToString()
        )
    }

    private fun calibrationValues(it: String) = "${it.first { it.isDigit() }}${it.last { it.isDigit() }}".toInt()

    private companion object {
        private val wordToDigit: Map<String, Int> = mapOf(
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )
    }

    private fun String.wordsAtIndex(index: Int): List<String> =
        (3..this.length - index).map { length -> substring(index, index + length) }

}