package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day09 {

    fun solvePart1(lines: List<String>): Int = parse(lines).sumOf { extrapolate(it) }

    fun solvePart2(lines: List<String>): Int = parse(lines).map { it.reversed() }.sumOf { extrapolate(it) }

    private fun parse(lines: List<String>): List<List<Int>> = lines.map { it.split(" ").map { i -> i.toInt() } }

    private fun extrapolate(numbers: List<Int>): Int =
        if (numbers.all { it == 0 }) 0
        else numbers.windowed(2, 1)
            .map { it[1] - it[0] }
            .let { numbers.last() + extrapolate(it) }

}
