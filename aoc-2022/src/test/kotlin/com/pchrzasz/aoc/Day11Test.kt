package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 11")
class Day11Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val inputAsText = Resources.resourceAsText("test_input_day11.txt")
            val answer = Day11().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(10_605)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day11.txt")
            val answer = Day11().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(112_221)
        }
    }


    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            val inputAsText = Resources.resourceAsText("test_input_day11.txt")
            val answer = Day11().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo(2_713_310_158)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day11.txt")
            val answer = Day11().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo(25_272_176_808)
        }
    }

}