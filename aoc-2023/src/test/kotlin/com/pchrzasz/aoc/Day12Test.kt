package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 12")
class Day12Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            ???.### 1,1,3
            .??..??...?##. 1,1,3
            ?#?#?#?#?#?#?#? 1,3,1,6
            ????.#...#... 4,1,1
            ????.######..#####. 1,6,5
            ?###???????? 3,2,1
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day12().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(21)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day12.txt")
            val answer = Day12().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(7344)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            ???.### 1,1,3
            .??..??...?##. 1,1,3
            ?#?#?#?#?#?#?#? 1,3,1,6
            ????.#...#... 4,1,1
            ????.######..#####. 1,6,5
            ?###???????? 3,2,1
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day12().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(525152)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day12.txt")
            val answer = Day12().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(1088006519007)
        }
    }

}