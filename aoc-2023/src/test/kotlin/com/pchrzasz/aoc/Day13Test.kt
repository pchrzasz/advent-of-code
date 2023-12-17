package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 13")
class Day13Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            #.##..##.
            ..#.##.#.
            ##......#
            ##......#
            ..#.##.#.
            ..##..##.
            #.#.##.#.
            
            #...##..#
            #....#..#
            ..##..###
            #####.##.
            #####.##.
            ..##..###
            #....#..#
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day13().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(405)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day13.txt")
            val answer = Day13().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(34918)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            #.##..##.
            ..#.##.#.
            ##......#
            ##......#
            ..#.##.#.
            ..##..##.
            #.#.##.#.
            
            #...##..#
            #....#..#
            ..##..###
            #####.##.
            #####.##.
            ..##..###
            #....#..#
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day13().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(400)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day13.txt")
            val answer = Day13().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(33054)
        }
    }

}