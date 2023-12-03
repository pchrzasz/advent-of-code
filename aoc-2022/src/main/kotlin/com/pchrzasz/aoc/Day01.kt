package com.pchrzasz.aoc

class Day01 {

    fun solvePart1(input: String): Int = parseInput(input).first()
    fun solvePart2(input: String): Int = parseInput(input).take(3).sum()


    private fun parseInput(input: String): List<Int> =
        input.trim()
            .split("\n\n")
            .map { it.lines().sumOf { tr -> tr.toInt() } }
            .sortedDescending()

}