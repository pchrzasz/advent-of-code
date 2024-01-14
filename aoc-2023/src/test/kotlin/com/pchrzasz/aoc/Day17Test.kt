package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 17")
class Day17Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            2413432311323
            3215453535623
            3255245654254
            3446585845452
            4546657867536
            1438598798454
            4457876987766
            3637877979653
            4654967986887
            4564679986453
            1224686865563
            2546548887735
            4322674655533
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day17().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(102)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day17.txt")
            val answer = Day17().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(767)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            111111111111
            999999999991
            999999999991
            999999999991
            999999999991
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day17().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(71)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day17.txt")
            val answer = Day17().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(904)
        }
    }

}