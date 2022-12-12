package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 12")
class Day12Test {

    private val input = """
        Sabqponm
        abcryxxl
        accszExk
        acctuvwj
        abdefghi
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day12().solvePart1(input)

            Assertions.assertThat(answer).isEqualTo(31)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day12.txt")
            val answer = Day12().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(330)
        }
    }


    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            val answer = Day12().solvePart2(input)

            Assertions.assertThat(answer).isEqualTo(29)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day12.txt")
            val answer = Day12().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo(321)
        }
    }

}