package com.pchrzasz.aoc

import kotlin.math.absoluteValue
import kotlin.math.sign

class Day14 {
    fun solvePart1(input: String): Int {
        val cave: MutableSet<Point2D> = parseInput(input)
        val sandSource = Point2D(500, 0)
        return dropSand(cave.maxOf { it.y } + 1, sandSource, cave)
    }

    fun solvePart2(input: String): Int {
        val cave: MutableSet<Point2D> = parseInput(input)
        val sandSource = Point2D(500, 0)
        val minX: Int = cave.minOf { it.x }
        val maxX: Int = cave.maxOf { it.x }
        val maxY: Int = cave.maxOf { it.y }
        cave.addAll(Point2D(minX - maxY, maxY + 2).lineTo(Point2D(maxX + maxY, maxY + 2)))
        return dropSand(maxY + 3, sandSource, cave) + 1
    }

    private fun dropSand(voidStartsAt: Int, sandSource: Point2D, cave: MutableSet<Point2D>): Int {
        var start = sandSource
        var landed = 0
        while (true) {
            val next = listOf(start.down(), start.downLeft(), start.downRight()).firstOrNull { it !in cave }
            start = when {
                next == null && start == sandSource -> return landed
                next == null -> {
                    cave.add(start)
                    landed += 1
                    sandSource
                }

                next.y == voidStartsAt -> return landed
                else -> next
            }
        }
    }

    private fun parseInput(input: String): MutableSet<Point2D> =
        input.lines().flatMap { row ->
            row.split(" -> ")
                .map { Point2D.of(it) }
                .zipWithNext()
                .flatMap { (from, to) ->
                    from.lineTo(to)
                }
        }.toMutableSet()

    data class Point2D(val x: Int = 0, val y: Int = 0) {

        fun down(): Point2D = Point2D(x, y + 1)
        fun downLeft(): Point2D = Point2D(x - 1, y + 1)
        fun downRight(): Point2D = Point2D(x + 1, y + 1)

        fun lineTo(other: Point2D): List<Point2D> {
            val xDelta = (other.x - x).sign
            val yDelta = (other.y - y).sign
            val steps = maxOf((x - other.x).absoluteValue, (y - other.y).absoluteValue)
            return (1..steps).scan(this) { last, _ -> Point2D(last.x + xDelta, last.y + yDelta) }
        }

        companion object {
            fun of(input: String): Point2D =
                input.split(",").let { (x, y) -> Point2D(x.toInt(), y.toInt()) }
        }
    }
}