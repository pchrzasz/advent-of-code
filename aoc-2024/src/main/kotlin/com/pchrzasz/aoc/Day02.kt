package com.pchrzasz.aoc

import kotlin.math.absoluteValue

class Day02 {

    fun solvePart1(input: List<String>): Int = parse(input).count { isSafe(it) }

    fun solvePart2(input: List<String>): Int =
        parse(input)
            .count { report ->
                isSafe(report) || report.indices.any { indexToRemove ->
                    isSafe(report.filterIndexed { index, _ -> index != indexToRemove })
                }
            }

    private fun parse(lines: List<String>): List<List<Int>> = lines.map { it.split(" ").map { i -> i.toInt() } }

    private fun isSafe(report: List<Int>): Boolean {
        val isDecreasing = { prev: Int, next: Int -> next - prev < 0 }
        val result = isDecreasing(report[1], report[0])
        return report.zipWithNext().all { (current, next) ->
            isDecreasing(next, current) == result && ((next - current).absoluteValue in 1..3)
        }
    }

}