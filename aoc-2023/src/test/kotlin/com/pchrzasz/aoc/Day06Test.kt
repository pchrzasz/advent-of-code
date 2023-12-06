package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 6")
class Day06Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
           Time:      7  15   30
           Distance:  9  40  200
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day06().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(288)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day06.txt")
            val answer = Day06().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(4_568_778)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            Time:      7  15   30
            Distance:  9  40  200
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day06().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(71_503)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day06.txt")
            val answer = Day06().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(28_973_936)
        }
    }

}