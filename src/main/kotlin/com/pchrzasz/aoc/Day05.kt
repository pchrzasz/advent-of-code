package com.pchrzasz.aoc

import java.util.*

class Day05 {
    fun solvePart1(input: String): String {
        val stacks = extractStacks(input)
        extractMoveInstructions(input)
            .forEach { move ->
                repeat(move.amount) {
                    stacks[move.target].push(stacks[move.source].pop())
                }
            }
        return stacks.tops()
    }

    fun solvePart2(input: String): String {
        val stacks = extractStacks(input)
        extractMoveInstructions(input)
            .forEach { move ->
                (1..move.amount).map { stacks[move.source].pop() }.reversed().forEach { stacks[move.target].push(it) }
            }
        return stacks.tops()
    }

    private fun Array<Stack<String>>.tops() = joinToString("") { it.peek() }

    private fun extractMoveInstructions(input: String): List<Move> = input.lines()
        .dropWhile { !it.startsWith("move") }
        .map { row ->
            row.split(" ").let { parts ->
                Move(parts[1].toInt(), parts[3].toInt() - 1, parts[5].toInt() - 1)
            }
        }

    private fun extractStacks(input: String): Array<Stack<String>> {
        val nums = input.lines().takeWhile { it.isNotBlank() }.last().split(" ").last { it.isNotBlank() }.toInt()
        val stacks = Array(nums) { Stack<String>() }
        input.lines().takeWhile { it.isNotBlank() }.dropLast(1).reversed()
            .map { it.chunked() }
            .forEach {
                it.forEachIndexed { index, elem ->
                    if (elem.isNotBlank()) stacks[index].push(elem)
                }
            }
        return stacks
    }

    private data class Move(val amount: Int, val source: Int, val target: Int)

    private fun String.chunked() =
        chunked(4)
            .map {
                it.replace("[", "")
                    .replace("]", "")
                    .trim()
            }
}