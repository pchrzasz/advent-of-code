package com.pchrzasz.aoc

import kotlin.math.absoluteValue

class Day10 {
    fun solvePart1(input: String): Int {
        val instructionsState = parseInput(input)
        return (20..instructionsState.size step 40).sumOf { it * instructionsState[it - 1] }
    }

    fun solvePart2(input: String) {
        val instructionsState = parseInput(input)
        instructionsState.mapIndexed { pixel, signal ->
            (signal - (pixel % 40)).absoluteValue <= 1
        }.windowed(40, 40, false).forEach { row ->
            row.forEach { pixel ->
                print(if (pixel) '#' else ' ')
            }
            println()
        }
    }

    private fun parseInput(input: String) =
        buildList {
            add(1)
            input.lines().forEach {
                add(0)
                if (it.startsWith("addx")) add(it.substringAfter(" ").toInt())
            }
        }.runningReduce(Int::plus)
}