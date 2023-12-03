package com.pchrzasz.aoc

private const val PATH_TO_INPUT_FILE = "/day3/input.txt"

class Day03 {
    fun solvePart1(input: String): Int =
        input.lines().sumOf {
            it.sharedItem()
                .priority()
        }

    fun solvePart2(input: String): Int =
        input.lines().chunked(3).sumOf {
            it.sharedItem()
                .priority()
        }

    private fun String.sharedItem(): Char =
        listOf(
            substring(0..length / 2),
            substring(length / 2)
        ).sharedItem()

    private fun List<String>.sharedItem(): Char =
        map { it.toSet() }
            .reduce { left, right -> left intersect right }
            .first()

    private fun Char.priority(): Int =
        when (this) {
            in 'a'..'z' -> (this - 'a') + 1
            in 'A'..'Z' -> (this - 'A') + 27
            else -> throw IllegalArgumentException("Letter not in range: $this")
        }
}