package com.pchrzasz.aoc

import com.pchrzasz.aoc.Day14.Point2D.Companion.EAST
import com.pchrzasz.aoc.Day14.Point2D.Companion.NORTH
import com.pchrzasz.aoc.Day14.Point2D.Companion.SOUTH
import com.pchrzasz.aoc.Day14.Point2D.Companion.WEST

/**
 * @author Paweł Chrząszczewski
 */
class Day14 {

    fun solvePart1(lines: List<String>): Int {
        val grid = lines.map { it.toCharArray() }.toTypedArray()
        grid.getNorthRoundedRocks()
            .forEach { tilt(grid, it, NORTH) }
        return grid.result()
    }

    fun solvePart2(lines: List<String>): Int {
        val cycleGoal = 1_000_000_000
        val grid = lines.map { it.toCharArray() }.toTypedArray()
        val seen = mutableMapOf<Int, Int>()
        var cycleNumber = 1
        while (cycleNumber <= cycleGoal) {
            doCycle(grid)
            val state = grid.sumOf { it.joinToString("").hashCode() }
            when {
                !seen.containsKey(state) -> seen[state] = cycleNumber++
                else -> {
                    val cycleRemaining = (cycleGoal - cycleNumber) % (cycleNumber - seen[state]!!)
                    repeat(cycleRemaining) {
                        doCycle(grid)
                    }
                    return grid.result()
                }
            }

        }
        return grid.result()
    }

    private fun doCycle(grid: Array<CharArray>) {
        grid.getNorthRoundedRocks()
            .forEach { tilt(grid, it, NORTH) }
        grid.getWestRoundedRocks()
            .forEach { tilt(grid, it, WEST) }
        grid.getSouthRoundedRocks()
            .forEach { tilt(grid, it, SOUTH) }
        grid.getEastRoundedRocks()
            .forEach { tilt(grid, it, EAST) }
    }


    private fun tilt(grid: Array<CharArray>, point: Point2D, north: Point2D) {
        var current = point
        while (grid.isAllowed(current + north) && grid[current + north] == '.') {
            grid[current + north] = 'O'
            grid[current] = '.'
            current += north
        }
    }

    private fun Array<CharArray>.getNorthRoundedRocks(): List<Point2D> =
        this.indices.flatMap { y ->
            this.first().indices.map { x ->
                if (this[y][x] == 'O') Point2D(x, y)
                else null
            }
        }.filterNotNull()

    private fun Array<CharArray>.getWestRoundedRocks(): List<Point2D> =
        this.first().indices.flatMap { x ->
            this.indices.map { y ->
                if (this[y][x] == 'O') Point2D(x, y)
                else null
            }
        }.filterNotNull()

    private fun Array<CharArray>.getSouthRoundedRocks(): List<Point2D> =
        this.indices.reversed().flatMap { y ->
            this.first().indices.map { x ->
                if (this[y][x] == 'O') Point2D(x, y)
                else null
            }
        }.filterNotNull()

    private fun Array<CharArray>.getEastRoundedRocks(): List<Point2D> =
        this.first().indices.reversed().flatMap { x ->
            this.indices.map { y ->
                if (this[y][x] == 'O') Point2D(x, y)
                else null
            }
        }.filterNotNull()

    private fun Array<CharArray>.result(): Int =
        this.mapIndexed { y, row ->
            row.filter { it == 'O' }.sumOf { size - y }
        }.sum()

    private data class Point2D(val x: Int, val y: Int) {

        operator fun plus(other: Point2D): Point2D =
            Point2D(x + other.x, y + other.y)

        companion object {
            val NORTH = Point2D(0, -1)
            val EAST = Point2D(1, 0)
            val SOUTH = Point2D(0, 1)
            val WEST = Point2D(-1, 0)
        }
    }

    private operator fun Array<CharArray>.get(at: Point2D): Char =
        this[at.y][at.x]

    private operator fun Array<CharArray>.set(at: Point2D, value: Char) {
        this[at.y][at.x] = value
    }

    private fun Array<CharArray>.isAllowed(at: Point2D) =
        at.y in this.indices && at.x in this[at.y].indices
}
