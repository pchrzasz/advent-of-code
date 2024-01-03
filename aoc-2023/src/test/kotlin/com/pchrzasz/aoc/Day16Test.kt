package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 16")
class Day16Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            .|...\....
            |.-.\.....
            .....|-...
            ........|.
            ..........
            .........\
            ..../.\\..
            .-.-/..|..
            .|....-|.\
            ..//.|....
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day16().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(46)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day16.txt")
            val answer = Day16().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(7623)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            .|...\....
            |.-.\.....
            .....|-...
            ........|.
            ..........
            .........\
            ..../.\\..
            .-.-/..|..
            .|....-|.\
            ..//.|....
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day16().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(51)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day16.txt")
            val answer = Day16().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(8244)
        }
    }

}