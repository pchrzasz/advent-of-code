package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Day14Test {

    private val input = """
        498,4 -> 498,6 -> 496,6
        503,4 -> 502,4 -> 502,9 -> 494,9
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day14().solvePart1(input)

            Assertions.assertThat(answer).isEqualTo(24)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day14.txt")
            val answer = Day14().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(578)
        }
    }


    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            val answer = Day14().solvePart2(input)

            Assertions.assertThat(answer).isEqualTo(93)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day14.txt")
            val answer = Day14().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo(24377)
        }
    }

}