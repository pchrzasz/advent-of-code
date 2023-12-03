package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val inputAsText = Resources.resourceAsText("test_input_day10.txt")
            val answer = Day10().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(13_140)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day10.txt")
            val answer = Day10().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(14_860)
        }
    }


    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            val inputAsText = Resources.resourceAsText("test_input_day10.txt")
            Day10().solvePart2(inputAsText)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day10.txt")
            Day10().solvePart2(inputAsText)
        }
    }

}