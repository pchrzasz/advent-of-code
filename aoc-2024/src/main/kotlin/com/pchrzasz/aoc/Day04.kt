package com.pchrzasz.aoc

class Day04 {

    private companion object {
        val ALL_DIRECTIONS = listOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        )
        val NODES = listOf(-1 to -1, -1 to 1, 1 to 1, 1 to -1)
        val POSSIBLE_NODES = setOf("MMSS", "MSSM", "SSMM", "SMMS")
    }

    fun solvePart1(input: List<String>): Int {
        val map = input.map { line -> line.map { it } }
        return map.mapIndexed { y, row ->
            row.mapIndexed { x, xyVal ->
                if (xyVal == 'X') {
                    ALL_DIRECTIONS.sumOf { vector ->
                        vectorFind(
                            "MAS",
                            map,
                            x + vector.first,
                            y + vector.second,
                            vector
                        )
                    }
                } else {
                    0
                }
            }.sum()
        }.sum()
    }

    fun solvePart2(input: List<String>): Int {
        val map = input.map { line -> line.map { it } }
        return map.mapIndexed { y, row ->
            row.mapIndexed { x, xyVal ->
                if (xyVal == 'A') {
                    if (NODES.map { map.at(y + it.first, x + it.second) }.joinToString("") in POSSIBLE_NODES) 1 else 0
                } else {
                    0
                }
            }.sum()
        }.sum()
    }

    private tailrec fun vectorFind(
        target: String,
        map: List<List<Char>>,
        x: Int,
        y: Int,
        vector: Pair<Int, Int>
    ): Int =
        when {
            target.isEmpty() -> 1
            map.isSafe(y, x) && (target.first() == map[y][x]) -> vectorFind(
                target.substring(1),
                map,
                x + vector.first,
                y + vector.second,
                vector
            )

            else -> 0
        }

    fun List<List<Char>>.isSafe(y: Int, x: Int): Boolean =
        y >= 0 && y < this.size && x >= 0 && x < this[0].size

    fun List<List<Char>>.at(y: Int, x: Int): Char =
        if (y >= 0 && y < this.size && x >= 0 && x < this[0].size) this[y][x] else ' '


}