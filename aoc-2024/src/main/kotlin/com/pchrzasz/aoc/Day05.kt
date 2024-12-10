package com.pchrzasz.aoc

class Day05 {

    fun solvePart1(input: List<String>): Int {
        val rules = input.takeWhile { it.isNotEmpty() }.toSet()
        val updates = input.dropWhile { it.isNotEmpty() }.drop(1).map { it.split(",") }
        val comparator = Comparator<String> { a, b ->
            when {
                "$a|$b" in rules -> -1
                "$b|$a" in rules -> 1
                else -> 0
            }
        }
        return updates.filter { it == it.sortedWith(comparator) }
            .map { it[it.size / 2] }
            .sumOf { it.toInt() }
    }

    fun solvePart2(input: List<String>): Int {
        val rules = input.takeWhile { it.isNotEmpty() }.toSet()
        val updates = input.dropWhile { it.isNotEmpty() }.drop(1).map { it.split(",") }
        val comparator = Comparator<String> { a, b ->
            when {
                "$a|$b" in rules -> -1
                "$b|$a" in rules -> 1
                else -> 0
            }
        }
        return updates.map { it to it.sortedWith(comparator) }
            .filter { (notSorted, sorted) -> notSorted != sorted }
            .map { (_, sorted) -> sorted[sorted.size / 2] }
            .sumOf { it.toInt() }
    }

}