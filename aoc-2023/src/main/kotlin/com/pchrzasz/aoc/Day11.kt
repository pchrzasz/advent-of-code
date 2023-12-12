package com.pchrzasz.aoc

import kotlin.math.absoluteValue

/**
 * @author Paweł Chrząszczewski
 */
class Day11 {

    fun solvePart1(lines: List<String>): Int {
        val galaxies = parseGalaxies(lines)
        val expandedGalaxies = expandGalaxy(galaxies)
        return expandedGalaxies.pointPairs().sumOf { it.first.distanceTo(it.second) }
    }

    fun solvePart2(lines: List<String>, spreadFactor: Int): Long {
        val galaxies = parseGalaxies(lines)
        val expandedGalaxies = expandGalaxy(galaxies, spreadFactor)
        return expandedGalaxies.pointPairs().sumOf { it.first.distanceTo(it.second).toLong() }
    }

    private fun <E> List<E>.pointPairs(): List<Pair<E, E>> =
        this.flatMapIndexed { index, left ->
            this.indices.drop(index).map { right -> left to this[right] }
        }

    private fun expandGalaxy(galaxies: List<Point2D>, spreadFactor: Int = 2): List<Point2D> {
        val addGalaxiesOnXAxis = findAddGalaxies(galaxies) { it.x }
        val addGalaxiesOnYAxis = findAddGalaxies(galaxies) { it.y }
        return galaxies.map { point ->
            Point2D(
                x = point.x + (addGalaxiesOnXAxis[point.x] * (spreadFactor - 1)),
                y = point.y + (addGalaxiesOnYAxis[point.y] * (spreadFactor - 1))
            )
        }
    }

    private fun findAddGalaxies(galaxies: List<Point2D>, axis: (Point2D) -> Int): List<Int> {
        val galaxiesOnAxis: Set<Int> = galaxies.map(axis).toSet()
        val initial = if (0 in galaxiesOnAxis) 0 else 1
        return IntArray(galaxiesOnAxis.max() + 1)
            .scanIndexed(initial) { index, acc, _ -> acc + if (index !in galaxiesOnAxis) 1 else 0 }
    }

    private fun parseGalaxies(lines: List<String>) =
        lines.flatMapIndexed { y, row ->
            row.mapIndexedNotNull { x, char ->
                if (char == '#') Point2D(x, y)
                else null
            }
        }

    private data class Point2D(val x: Int, val y: Int) {
        fun distanceTo(other: Point2D): Int =
            (x - other.x).absoluteValue + (y - other.y).absoluteValue

    }
}
