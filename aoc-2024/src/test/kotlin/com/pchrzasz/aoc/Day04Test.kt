package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day04Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day04().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(18)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day04.txt")
            val answer = Day04().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(2297)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            .M.S......
            ..A..MSMS.
            .M.S.MAA..
            ..A.ASMSM.
            .M.S.M....
            ..........
            S.S.S.S.S.
            .A.A.A.A..
            M.M.M.M.M.
            ..........
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day04().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(9)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day04.txt")
            val answer = Day04().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(1745)
        }
    }

}