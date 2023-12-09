package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day08 {

    fun solvePart1(lines: List<String>): Int = solve("AAA", lines.first(), parseMap(lines))

    fun solvePart2(lines: List<String>): Long =
        parseMap(lines).let { routeMap ->
            routeMap.keys.filter { it.endsWith('A') }
                .map { solve(it, lines.first(), routeMap).toLong() }
                .reduce { prev, next -> prev.leastCommonMultiple(next) }
        }

    private fun solve(start: String, instructions: String, routeMap: Map<String, Pair<String, String>>): Int {
        var steps = 0
        var current = start
        while (!current.endsWith("Z")) {
            current = routeMap[current].let { route ->
                val instruction = instructions[steps++ % instructions.length]
                if (instruction == 'L') route!!.first else route!!.second
            }
        }
        return steps
    }

    private fun Long.leastCommonMultiple(other: Long): Long = (this * other) / this.greatestCommonDivisor(other)

    private fun Long.greatestCommonDivisor(other: Long): Long =
        if (other == 0L) this
        else other.greatestCommonDivisor(this % other)


    private fun parseMap(lines: List<String>) =
        lines.drop(2)
            .associate { line ->
                val parts = line.split("=")
                val values = parts[1].trim().removeSurrounding("(", ")").split(",").map { it.trim() }
                parts[0].trim() to (values[0] to values[1])
            }

}
