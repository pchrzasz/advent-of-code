package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day13 {

    fun solvePart1(lines: List<String>): Int = parseInput(lines).map {
        findVertical(it, 0) ?: findHorizontal(it, 0) ?: 0
    }.sumOf { it }

    fun solvePart2(lines: List<String>): Int = parseInput(lines).map {
        findVertical(it, 1) ?: findHorizontal(it, 1) ?: 0
    }.sumOf { it }

    private fun findVertical(pattern: List<String>, diffResult: Int): Int? {
        val result = (0..pattern[0].length - 2).firstOrNull {
            createMirrorRanges(it, pattern[0].lastIndex)
                .map { (left, right) ->
                    pattern.columnToString(left).diff(pattern.columnToString(right))
                }.sumOf { it } == diffResult
        }
        return if (result != null) result + 1
        else null
    }

    private fun findHorizontal(pattern: List<String>, diffResult: Int): Int? {
        val result = (0..pattern.size - 2).firstOrNull {
            createMirrorRanges(it, pattern.size - 1)
                .map { (top, bottom) ->
                    pattern[top].diff(pattern[bottom])
                }.sumOf { it } == diffResult
        }
        return if (result != null) (result + 1) * 100
        else null
    }


    private fun parseInput(input: List<String>): List<List<String>> =
        input.joinToString("\n").split("\n\n").map { it.lines() }

    private fun createMirrorRanges(start: Int, max: Int): List<Pair<Int, Int>> =
        (start downTo 0).zip(start + 1..max)

    private infix fun String.diff(other: String): Int = indices.count { this[it] != other[it] }

    private fun List<String>.columnToString(column: Int): String =
        this.map { it[column] }.joinToString("")


}
