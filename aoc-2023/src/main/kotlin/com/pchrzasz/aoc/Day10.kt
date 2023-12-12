package com.pchrzasz.aoc

import com.pchrzasz.aoc.Day10.Point2D.Companion.EAST
import com.pchrzasz.aoc.Day10.Point2D.Companion.NORTH
import com.pchrzasz.aoc.Day10.Point2D.Companion.SOUTH
import com.pchrzasz.aoc.Day10.Point2D.Companion.WEST

/**
 * @author Paweł Chrząszczewski
 */
class Day10 {

    fun solvePart1(lines: List<String>): Int {
        val map = lines.map { it.toCharArray() }.toTypedArray()
        val startingPoint = map.indexOfFirst { 'S' in it }.let { y -> Point2D(map[y].indexOf('S'), y) }
        return traversePipe(startingPoint, map).size / 2
    }

    fun solvePart2(lines: List<String>): Int {
        val map = lines.map { it.toCharArray() }.toTypedArray()
        val startingPoint = map.indexOfFirst { 'S' in it }.let { y -> Point2D(map[y].indexOf('S'), y) }
        val pipe = traversePipe(startingPoint, map)
        return searchNests(pipe, map)
    }


    private fun traversePipe(startingPoint: Point2D, map: Array<CharArray>): Set<Point2D> {
        val pipe = mutableSetOf(startingPoint)
        var current = startingPoint
            .neighbors()
            .filter { map.isSafe(it) }
            .first {
                val direction = it - startingPoint
                (map[it.y][it.x] to direction in possibleMovements)
            }
        var direction = current - startingPoint
        while (current != startingPoint) {
            pipe += current
            possibleMovements[map[current.y][current.x] to direction]?.let { nextDirection ->
                direction = nextDirection
                current += direction
            } ?: throw IllegalArgumentException("Not possible movement")
        }
        return pipe
    }

    private fun searchNests(pipes: Set<Point2D>, map: Array<CharArray>): Int {
        fun countInvs(y: Int, x: Int): Int {
            var count = 0
            for (k in (0 until x)) {
                if (pipes.contains(Point2D(k, y)) && setOf('J', 'L', '|').contains(map[y][k]))
                    count += 1
            }
            return count
        }

        var nests = 0;
        for (y in map.indices) {
            for (x in map[y].indices) {
                if (!pipes.contains(Point2D(x, y)) && countInvs(y, x) % 2 == 1)
                    nests += 1
            }
        }
        return nests;
    }

    private val possibleMovements: Map<Pair<Char, Point2D>, Point2D> =
        mapOf(
            ('|' to SOUTH) to SOUTH,
            ('|' to NORTH) to NORTH,
            ('-' to EAST) to EAST,
            ('-' to WEST) to WEST,
            ('L' to WEST) to NORTH,
            ('L' to SOUTH) to EAST,
            ('J' to SOUTH) to WEST,
            ('J' to EAST) to NORTH,
            ('7' to EAST) to SOUTH,
            ('7' to NORTH) to WEST,
            ('F' to WEST) to SOUTH,
            ('F' to NORTH) to EAST
        )

    private fun Array<CharArray>.isSafe(at: Point2D) =
        at.y in this.indices && at.x in this[at.y].indices

    private data class Point2D(val x: Int, val y: Int) {

        fun neighbors(): Set<Point2D> =
            setOf(
                this + NORTH,
                this + EAST,
                this + SOUTH,
                this + WEST
            )

        operator fun minus(other: Point2D): Point2D =
            Point2D(x - other.x, y - other.y)

        operator fun plus(other: Point2D): Point2D =
            Point2D(x + other.x, y + other.y)

        companion object {
            val NORTH = Point2D(0, -1)
            val EAST = Point2D(1, 0)
            val SOUTH = Point2D(0, 1)
            val WEST = Point2D(-1, 0)
        }
    }

}
