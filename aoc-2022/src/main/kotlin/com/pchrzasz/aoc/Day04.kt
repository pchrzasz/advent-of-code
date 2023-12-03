package com.pchrzasz.aoc

private const val PATH_TO_INPUT_FILE = "/day4/input.txt"

class Day04 {
    fun solvePart1(input: String): Int =
        input.lines().map { it.asRanges() }.count {
            it.first.fullyOverlaps(it.second) || it.second.fullyOverlaps(it.first)
        }

    fun solvePart2(input: String): Int =
        input.lines().map { it.asRanges() }.count {
            it.first.overlaps(it.second) || it.second.overlaps(it.first)
        }
}

private fun String.asRanges(): Pair<IntRange, IntRange> =
    substringBefore(",").asIntRange() to substringAfter(",").asIntRange()

private fun String.asIntRange(): IntRange =
    substringBefore("-").toInt()..substringAfter("-").toInt()

private fun IntRange.fullyOverlaps(other: IntRange): Boolean =
    first <= other.first && last >= other.last

private fun IntRange.overlaps(other: IntRange): Boolean =
    first <= other.last && other.first <= last