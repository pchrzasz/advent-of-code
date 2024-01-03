package com.pchrzasz.aoc

import com.pchrzasz.aoc.Day16.Point2D.Companion.EAST
import com.pchrzasz.aoc.Day16.Point2D.Companion.NORTH
import com.pchrzasz.aoc.Day16.Point2D.Companion.SOUTH
import com.pchrzasz.aoc.Day16.Point2D.Companion.WEST

/**
 * @author Paweł Chrząszczewski
 */
class Day16 {

    fun solvePart1(lines: List<String>): Int =
        lines.map { it.toCharArray() }
            .toTypedArray()
            .execute(Point2D(0, 0), EAST);

    fun solvePart2(lines: List<String>): Int {
        val grid = lines.map { it.toCharArray() }.toTypedArray()
        return listOf(
            grid.first().indices.map { Point2D(it, 0) to SOUTH },
            grid.first().indices.map { Point2D(it, grid.lastIndex) to NORTH },
            grid.indices.map { Point2D(0, it) to EAST },
            grid.indices.map { Point2D(grid.first().lastIndex, it) to WEST }
        ).flatten().maxOf { grid.execute(it.first, it.second) }
    }

    private fun Array<CharArray>.execute(startPoint: Point2D, startDirection: Point2D): Int {
        val seen = mutableSetOf(startPoint to startDirection)
        val queue = ArrayDeque<Pair<Point2D, Point2D>>().apply { add(startPoint to startDirection) }
        while (queue.isNotEmpty()) {
            val (point, direction) = queue.removeFirst()
            val newDirections = movements[this[point] to direction] ?: listOf(direction)
            newDirections.forEach { newDirection ->
                val nextPoint = point + newDirection
                if ((nextPoint to newDirection) !in seen && this.isInGrid(nextPoint)) {
                    seen.add(nextPoint to newDirection)
                    queue.add(nextPoint to newDirection)
                }
            }

        }
        return seen.map { it.first }.toSet().size
    }

    private val movements = mapOf(
        '-' to NORTH to listOf(EAST, WEST),
        '-' to SOUTH to listOf(EAST, WEST),
        '|' to EAST to listOf(NORTH, SOUTH),
        '|' to WEST to listOf(NORTH, SOUTH),
        '\\' to NORTH to listOf(WEST),
        '\\' to WEST to listOf(NORTH),
        '\\' to SOUTH to listOf(EAST),
        '\\' to EAST to listOf(SOUTH),
        '/' to NORTH to listOf(EAST),
        '/' to WEST to listOf(SOUTH),
        '/' to SOUTH to listOf(WEST),
        '/' to EAST to listOf(NORTH)
    )

    private data class Point2D(val x: Int, val y: Int) {

        companion object {
            val NORTH = Point2D(0, -1)
            val EAST = Point2D(1, 0)
            val SOUTH = Point2D(0, 1)
            val WEST = Point2D(-1, 0)
        }

        operator fun plus(other: Point2D): Point2D =
            Point2D(x + other.x, y + other.y)
    }

    private operator fun Array<CharArray>.get(at: Point2D): Char =
        this[at.y][at.x]

    private fun Array<CharArray>.isInGrid(at: Point2D) =
        at.y in this.indices && at.x in this[at.y].indices

}
