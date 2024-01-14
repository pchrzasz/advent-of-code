package com.pchrzasz.aoc

import com.pchrzasz.aoc.Day17.Point2D.Companion.EAST
import com.pchrzasz.aoc.Day17.Point2D.Companion.NORTH
import com.pchrzasz.aoc.Day17.Point2D.Companion.SOUTH
import com.pchrzasz.aoc.Day17.Point2D.Companion.WEST
import java.util.PriorityQueue

/**
 * @author Paweł Chrząszczewski
 */
class Day17 {

    fun solvePart1(lines: List<String>): Int {
        val grid = lines.map { row -> row.map { it.digitToInt() } }
        return calculateHeatLoss(grid) { state, nextDirection ->
            state.steps < 3 || state.direction != nextDirection
        }
    }

    fun solvePart2(lines: List<String>): Int {
        val grid = lines.map { row -> row.map { it.digitToInt() } }
        return calculateHeatLoss(grid, minSteps = 4) { state, nextDirection ->
            if (state.steps > 9) state.direction != nextDirection
            else if (state.steps < 4) state.direction == nextDirection
            else true
        }
    }


    private fun calculateHeatLoss(
        grid: List<List<Int>>,
        minSteps: Int = 1,
        isValidNextMove: (State, Point2D) -> Boolean
    ): Int {
        val goal = Point2D(grid.first().lastIndex, grid.lastIndex)
        val seen = mutableSetOf<State>()
        val queue = PriorityQueue<Work>()

        listOf(EAST, SOUTH).forEach { startDirection ->
            State(Point2D(0, 0), startDirection, 0).apply {
                queue += Work(this, 0)
                seen += this
            }
        }

        while (queue.isNotEmpty()) {
            val (current, heatLoss) = queue.poll()
            if (current.location == goal && current.steps >= minSteps) return heatLoss

            movements
                .getValue(current.direction)
                .filter { direction ->
                    grid.isInGrid(current.location + direction) and
                            isValidNextMove(current, direction)
                }
                .map { direction -> current.next(direction) }
                .filter { state -> state !in seen }
                .forEach { state ->
                    queue += Work(state, heatLoss + grid[state.location])
                    seen += state
                }
        }
        throw IllegalStateException("Did not find route to goal")
    }

    private data class State(val location: Point2D, val direction: Point2D, val steps: Int) {
        fun next(nextDirection: Point2D): State =
            State(location + nextDirection, nextDirection, if (direction == nextDirection) steps + 1 else 1)
    }

    private data class Work(val state: State, val heatLoss: Int) : Comparable<Work> {
        override fun compareTo(other: Work): Int =
            heatLoss - other.heatLoss
    }


    private val movements = mapOf(
        NORTH to listOf(NORTH, EAST, WEST),
        SOUTH to listOf(SOUTH, EAST, WEST),
        EAST to listOf(NORTH, SOUTH, EAST),
        WEST to listOf(NORTH, SOUTH, WEST),
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

    private operator fun List<List<Int>>.get(at: Point2D): Int =
        this[at.y][at.x]

    private fun List<List<Int>>.isInGrid(at: Point2D) =
        at.y in this.indices && at.x in this[at.y].indices

}
