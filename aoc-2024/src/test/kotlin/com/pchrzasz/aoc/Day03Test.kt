package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day03Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day03().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(161)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day03.txt")
            val answer = Day03().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(153469856)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day03().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(48)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day03.txt")
            val answer = Day03().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(77055967)
        }
    }

}