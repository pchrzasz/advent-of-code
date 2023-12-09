package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 8")
class Day08Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            LLR
            
            AAA = (BBB, BBB)
            BBB = (AAA, ZZZ)
            ZZZ = (ZZZ, ZZZ)
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day08().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(6)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day08.txt")
            val answer = Day08().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(19783)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            LR
            
            11A = (11B, XXX)
            11B = (XXX, 11Z)
            11Z = (11B, XXX)
            22A = (22B, XXX)
            22B = (22C, 22C)
            22C = (22Z, 22Z)
            22Z = (22B, 22B)
            XXX = (XXX, XXX)
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day08().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(6)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day08.txt")
            val answer = Day08().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(9177460370549L)
        }
    }

}