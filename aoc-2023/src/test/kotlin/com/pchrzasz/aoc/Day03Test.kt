package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 3")
class Day03Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day03().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(4361)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day03.txt")
            val answer = Day03().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(527_364)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day03().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(467_835)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day03.txt")
            val answer = Day03().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(79_026_871)
        }
    }

}