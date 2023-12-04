package com.pchrzasz.aoc

import kotlin.math.pow

/**
 * @author Paweł Chrząszczewski
 */
class Day04 {

    fun solvePart1(lines: List<String>): Int =
        readCards(lines)
            .map { it.first.intersect(it.second).size }
            .filter { it > 0 }
            .map { 2.0.pow((it - 1).toDouble()).toInt() }
            .sumOf { it }

    fun solvePart2(lines: List<String>): Int =
        readCards(lines)
            .foldIndexed(IntArray(lines.size) { 1 }) { startIndex, acc, winningToActual ->
                val matches = winningToActual.first.intersect(winningToActual.second).size
                repeat(acc[startIndex]) { (startIndex + 1..startIndex + matches).forEach { if (it < acc.size) acc[it]++ } }
                acc
            }
            .sumOf { it }

    private fun readCards(rows: List<String>): List<Pair<List<Int>, List<Int>>> {
        val parseNumbers: (String) -> List<Int> = { it.split(" ").mapNotNull { numStr -> numStr.toIntOrNull() } }

        return rows.map { it.split("|").map { it.trim() } }
            .filter { it.size == 2 }
            .map { parseNumbers(it[0]) to parseNumbers(it[1]) }
    }


}