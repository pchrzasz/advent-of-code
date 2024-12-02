package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day01().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(11)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day01.txt")
            val answer = Day01().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(1_834_060)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day01().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(31)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day01.txt")
            val answer = Day01().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(21607792)
        }
    }

}