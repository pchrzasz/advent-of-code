package com.pchrzasz.aoc

class Day03 {

    private val regexMul = """mul\((\d+),\s*(\d+)\)""".toRegex()
    private val regexInput = """(^|do\(\)).*?($|don't\(\))""".toRegex()

    fun solvePart1(input: List<String>): Int = input.sumOf { result(it) }

    fun solvePart2(input: List<String>): Int =
        input.flatMap { regexInput.findAll(it).map { it.value }.toList() }
            .sumOf { result(it) }

    private fun result(input: String): Int =
        regexMul.findAll(input)
            .map {
                val (num1, num2) = it.destructured
                num1.toInt() * num2.toInt()
            }
            .sum()

}