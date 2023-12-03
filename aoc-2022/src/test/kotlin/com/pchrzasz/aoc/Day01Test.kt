package com.pchrzasz.aoc

import com.pchrzasz.aoc.Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {
    private val input = """
        1000
        2000
        3000
        
        4000
        
        5000
        6000
        
        7000
        8000
        9000
        
        10000
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day01().solvePart1(input)

            assertThat(answer).isEqualTo(24_000)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = resourceAsText("input_day01.txt")
            val answer = Day01().solvePart1(inputAsText)

            assertThat(answer).isEqualTo(70_698)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day01().solvePart2(input)

            assertThat(answer).isEqualTo(45_000)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = resourceAsText("input_day01.txt")
            val answer = Day01().solvePart2(inputAsText)

            assertThat(answer).isEqualTo(206_643)
        }
    }
}