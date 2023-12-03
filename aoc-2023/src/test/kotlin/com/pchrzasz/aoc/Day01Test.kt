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
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day01().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(142)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day01.txt")
            val answer = Day01().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(54_081)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day01().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(281)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day01.txt")
            val answer = Day01().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(54_649)
        }
    }

}