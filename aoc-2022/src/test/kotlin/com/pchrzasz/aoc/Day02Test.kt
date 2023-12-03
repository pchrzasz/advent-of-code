package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day02Test {

    private val input = """
        A Y
        B X
        C Z
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day02().solvePart1(input)

            Assertions.assertThat(answer).isEqualTo(15)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day02.txt")
            val answer = Day02().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(11_449)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day02().solvePart2(input)

            Assertions.assertThat(answer).isEqualTo(12)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day02.txt")
            val answer = Day02().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo(13_187)
        }
    }

}