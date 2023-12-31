package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 15")
class Day15Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day15().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(1320)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day15.txt")
            val answer = Day15().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(514281)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day15().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(145)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day15.txt")
            val answer = Day15().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(244199)
        }
    }

}