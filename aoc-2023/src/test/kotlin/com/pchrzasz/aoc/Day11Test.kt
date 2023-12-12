package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 11")
class Day11Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            ...#......
            .......#..
            #.........
            ..........
            ......#...
            .#........
            .........#
            ..........
            .......#..
            #...#.....
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day11().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(374)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day11.txt")
            val answer = Day11().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(9686930)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            ...#......
            .......#..
            #.........
            ..........
            ......#...
            .#........
            .........#
            ..........
            .......#..
            #...#.....
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day11().solvePart2(input.lines(), 100)

            Assertions.assertThat(answer).isEqualTo(8410)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day11.txt")
            val answer = Day11().solvePart2(inputAsText.lines(), 1_000_000)

            Assertions.assertThat(answer).isEqualTo(630728425490)
        }
    }

}