package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 8")
class Day08Test {

    private val input = """
        30373
        25512
        65332
        33549
        35390
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day08().solvePart1(input)

            Assertions.assertThat(answer).isEqualTo(21)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day08.txt")
            val answer = Day08().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(1_672)
        }
    }


    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day08().solvePart2(input)

            Assertions.assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day08.txt")
            val answer = Day08().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo(327180)
        }
    }

}