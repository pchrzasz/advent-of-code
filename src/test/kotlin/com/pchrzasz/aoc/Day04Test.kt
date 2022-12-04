package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day04Test {

    private val input = """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day04().solvePart1(input)

            Assertions.assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day04.txt")
            val answer = Day04().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(483)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day04().solvePart2(input)

            Assertions.assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day04.txt")
            val answer = Day04().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo(874)
        }
    }

}