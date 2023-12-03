package com.pchrzasz.aoc

class Day08 {
    fun solvePart1(input: String): Int {
        val grid = Grid.from(input)
        return (1 until grid.height - 1).sumOf { y ->
            (1 until grid.width - 1).count { x ->
                grid.isVisible(x, y)
            }
        } + (2 * grid.height) + (2 * grid.width) - 4
    }

    fun solvePart2(input: String): Int {
        val grid = Grid.from(input)
        return (1 until grid.height - 1).maxOf { y ->
            (1 until grid.width - 1).maxOf { x ->
                grid.scoreAt(x, y)
            }
        }
    }

    private class Grid(private val grid: Array<IntArray>) {

        val height: Int by lazy { grid.size }
        val width: Int by lazy { grid.first().size }

        companion object {
            fun from(input: String): Grid {
                return Grid(input.lines().map { row ->
                    row.map(Char::digitToInt).toIntArray()
                }.toTypedArray())
            }
        }

        fun scoreAt(x: Int, y: Int): Int =
            listOf(
                (x - 1 downTo 0).map { grid[it][y] }, // top
                (x + 1 until height).map { grid[it][y] }, // bottom
                grid[x].take(y).asReversed(), // left
                grid[x].drop(y + 1) // right
            ).map { direction ->
                direction.takeWhileInclusive { it < grid[x][y] }.count()
            }.reduce { acc, el -> acc * el }

        fun isVisible(x: Int, y: Int): Boolean =
            visibleFromLeft(x, y) || visibleFromRight(x, y) ||
                    visibleFromTop(x, y) || visibleFromBottom(x, y)

        private fun visibleFromLeft(x: Int, y: Int): Boolean =
            (0 until y).all { grid[x][y] > grid[x][it] }

        private fun visibleFromRight(x: Int, y: Int): Boolean =
            (width - 1 downTo y + 1).all { grid[x][y] > grid[x][it] }

        private fun visibleFromTop(x: Int, y: Int): Boolean =
            (0 until x).all { grid[it][y] < grid[x][y] }

        private fun visibleFromBottom(x: Int, y: Int): Boolean =
            (height - 1 downTo x + 1).all { grid[it][y] < grid[x][y] }
    }
}

inline fun <T> Iterable<T>.takeWhileInclusive(
    predicate: (T) -> Boolean
): List<T> {
    var shouldContinue = true
    return takeWhile {
        val result = shouldContinue
        shouldContinue = predicate(it)
        result
    }
}