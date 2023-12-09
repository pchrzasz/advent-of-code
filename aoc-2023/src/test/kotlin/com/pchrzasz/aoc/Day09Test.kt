package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 9")
class Day09Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            0 3 6 9 12 15
            1 3 6 10 15 21
            10 13 16 21 30 45
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day09().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(114)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day09.txt")
            val answer = Day09().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(1898776583)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            0 3 6 9 12 15
            1 3 6 10 15 21
            10 13 16 21 30 45
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day09().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day09.txt")
            val answer = Day09().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(1100)
        }
    }

}