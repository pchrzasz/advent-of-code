package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day12 {

    fun solvePart1(lines: List<String>): Long = lines.map { parseRow(it) }.sumOf { count(it.first, it.second) }

    fun solvePart2(lines: List<String>): Long =
        lines.map { parseRow(it) }.map { unfold(it) }.sumOf { count(it.first, it.second) }

    private val cache: MutableMap<Pair<String, List<Int>>, Long> = HashMap()

    private fun parseRow(input: String): Pair<String, List<Int>> =
        input.split(" ").run {
            first() to last().split(",").map { it.toInt() }
        }

    private fun unfold(input: Pair<String, List<Int>>): Pair<String, List<Int>> =
        (0..4).joinToString("?") { input.first } to (0..4).flatMap { input.second }

    private fun count(springs: String, damage: List<Int>): Long {
        val key = springs to damage
        if (springs.isEmpty()) {
            return if (damage.isEmpty()) 1 else 0
        }

        if (damage.isEmpty()) {
            return if ("#" in springs) 0 else 1
        }

        if (key in cache.keys) return cache[key]!!

        var result = 0L

        if (springs[0] in ".?") {
            result += count(springs.substring(1), damage)
        }

        if (springs[0] in "#?") {
            if (
                damage[0] <= springs.length &&
                "." !in springs.substring(0, damage[0]) &&
                (damage[0] == springs.length || springs[damage[0]] != '#')
            ) {
                result += if (damage[0] + 1 > springs.length) count("", damage.drop(1))
                else count(springs.substring(damage[0] + 1), damage.drop(1))
            }
        }

        cache[key] = result

        return result
    }


}
