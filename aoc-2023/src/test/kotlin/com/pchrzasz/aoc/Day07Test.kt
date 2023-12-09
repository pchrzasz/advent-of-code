package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 7")
class Day07Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            32T3K 765
            T55J5 684
            KK677 28
            KTJJT 220
            QQQJA 483
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day07().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(6440)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day07.txt")
            val answer = Day07().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(253205868)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            32T3K 765
            T55J5 684
            KK677 28
            KTJJT 220
            QQQJA 483
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day07().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(5905)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day07.txt")
            val answer = Day07().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(253907829)
        }
    }

}