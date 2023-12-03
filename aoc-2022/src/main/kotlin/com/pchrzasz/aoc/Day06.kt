package com.pchrzasz.aoc

class Day06 {
    fun solvePart1(input: String): Int =
        input.findStartMarker(4)

    fun solvePart2(input: String): Int =
        input.findStartMarker(14)

    private fun String.findStartMarker(distinctCharsSize: Int): Int =
        withIndex()
            .windowed(distinctCharsSize, 1)
            .first { window ->
                window.map { it.value }.toSet().size == distinctCharsSize
            }
            .last().index + 1
}