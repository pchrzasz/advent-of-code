package com.pchrzasz.aoc

import kotlin.math.absoluteValue

class Day01 {

    fun solvePart1(input: List<String>): Int = parse(input).let { (left, right) ->
        left.sorted().zip(right.sorted()).sumOf { (it.first - it.second).absoluteValue }
    }

    fun solvePart2(input: List<String>): Int = parse(input).let { (left, right) ->
        left.sumOf { value -> value * right.count { it == value } }
    }

    private fun parse(input: List<String>): Pair<List<Int>, List<Int>> {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        input.forEach {
            left.add(it.substringBefore(" ").toInt())
            right.add(it.substringAfterLast(" ").toInt())
        }
        return left to right
    }

}