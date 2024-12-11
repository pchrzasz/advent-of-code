package com.pchrzasz.aoc

import com.pchrzasz.aoc.Day06.Point.Companion.EAST
import com.pchrzasz.aoc.Day06.Point.Companion.NORTH
import com.pchrzasz.aoc.Day06.Point.Companion.SOUTH
import com.pchrzasz.aoc.Day06.Point.Companion.WEST

class Day06 {

    fun solvePart1(input: List<String>): Int {
        val map = input.map { line -> line.toCharArray() }
        var next = findStart(map)
        var direction = NORTH
        val route = mutableListOf<Point>()
        while (!map.isFree(next, direction)) {
            val possible = next + direction
            if (map[possible.y][possible.x] == '#') {
                direction = rotate(direction)
            } else {
                next = possible
                route.add(next)
            }
        }
        return route.distinct().size
    }

    fun solvePart2(input: List<String>): Int {
        val map = input.map { line -> line.toCharArray() }
        val startingPoint = findStart(map)
        return map.mapIndexed { y, row ->
            row.mapIndexed { x, c ->
                if (c != '^') {
                    map[y][x] = '#'
                    val result = isCycle(map, startingPoint)
                    map[y][x] = c
                    if (result) 1 else 0
                } else 0
            }.sum()
        }.sum()
    }

    private fun isCycle(map: List<CharArray>, startingPoint: Point): Boolean {
        var direction = NORTH
        var next = startingPoint
        val seen = mutableSetOf<Pair<Point, Point>>()
        while (!map.isFree(next, direction)) {
            val possible = next + direction
            when {
                Pair(possible, direction) in seen -> return true
                map[possible.y][possible.x] == '#' -> direction = rotate(direction)
                else -> {
                    next = possible
                    seen.add(Pair(next, direction))
                }
            }
        }
        return false
    }

    private fun rotate(point: Point): Point =
        when (point) {
            NORTH -> EAST
            SOUTH -> WEST
            EAST -> SOUTH
            WEST -> NORTH
            else -> error("Unexpected point $point")
        }

    data class Point(val x: Int, val y: Int) {
        operator fun plus(other: Point) = Point(x + other.x, y + other.y)

        companion object {
            val NORTH = Point(0, -1)
            val EAST = Point(1, 0)
            val SOUTH = Point(0, 1)
            val WEST = Point(-1, 0)
        }
    }

    private fun findStart(map: List<CharArray>): Point =
        map.flatMapIndexed { y, row ->
            row.mapIndexed { x, value -> if (value == '^') Point(x, y) else null }
        }.filterNotNull().first()

    private fun List<CharArray>.isFree(point: Point, direction: Point): Boolean =
        (direction == NORTH && point.y == 0) || (direction == SOUTH && point.y == size - 1) ||
                (direction == EAST && point.x == this[0].size - 1) || (direction == WEST && point.x == 0)

    private operator fun List<CharArray>.set(at: Point, c: Char) {
        this[at.y][at.x] = c
    }
}


