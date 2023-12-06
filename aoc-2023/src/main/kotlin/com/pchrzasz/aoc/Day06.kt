package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day06 {

    fun solvePart1(lines: List<String>): Long {
        val times = parse(lines.first())
        val distances = parse(lines.drop(1).first())
        return times.zip(distances)
            .map { race(it.first, it.second) }
            .reduce(Long::times)
    }

    fun solvePart2(lines: List<String>): Long {
        val time = parse(lines.first()).joinToString("") { it.toString() }.toLong()
        val distance = parse(lines.drop(1).first()).joinToString("") { it.toString() }.toLong()
        return race(time, distance)
    }

    private fun parse(line: String): List<Long> =
        line.substringAfter(":").split(" ").filter { it.isNotEmpty() }.map { it.toLong() }

    private fun race(time: Long, distance: Long): Long =
        (1..time).filter { hold -> (time - hold) * hold > distance }.size.toLong()

}
