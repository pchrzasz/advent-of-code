package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 9")
class Day09Test {

    private val input = """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day09().solvePart1(input)

            Assertions.assertThat(answer).isEqualTo(13)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day09.txt")
            val answer = Day09().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(1_672)
        }
    }


    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val anotherInput = """
            R 5
            U 8
            L 8
            D 3
            R 17
            D 10
            L 25
            U 20
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day09().solvePart2(input)

            Assertions.assertThat(answer).isEqualTo(1)
        }

        @Test
        fun `Matches another example`() {
            val answer = Day09().solvePart2(anotherInput)

            Assertions.assertThat(answer).isEqualTo(36)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day09.txt")
            val answer = Day09().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo(2367)
        }
    }

}