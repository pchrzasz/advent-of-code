package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day02Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day02().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day02.txt")
            val answer = Day02().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(432)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day02().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day02.txt")
            val answer = Day02().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(488)
        }
    }

}