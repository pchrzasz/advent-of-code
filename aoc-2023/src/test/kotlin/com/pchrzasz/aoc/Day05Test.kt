package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 5")
class Day05Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            seeds: 79 14 55 13

            seed-to-soil map:
            50 98 2
            52 50 48

            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15

            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4

            water-to-light map:
            88 18 7
            18 25 70

            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13

            temperature-to-humidity map:
            0 69 1
            1 0 69

            humidity-to-location map:
            60 56 37
            56 93 4
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day05().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(35)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day05.txt")
            val answer = Day05().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(196167384)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        private val input = """
            seeds: 79 14 55 13

            seed-to-soil map:
            50 98 2
            52 50 48

            soil-to-fertilizer map:
            0 15 37
            37 52 2
            39 0 15

            fertilizer-to-water map:
            49 53 8
            0 11 42
            42 0 7
            57 7 4

            water-to-light map:
            88 18 7
            18 25 70

            light-to-temperature map:
            45 77 23
            81 45 19
            68 64 13

            temperature-to-humidity map:
            0 69 1
            1 0 69

            humidity-to-location map:
            60 56 37
            56 93 4
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day05().solvePart2(input.lines())

            Assertions.assertThat(answer).isEqualTo(46)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day05.txt")
            val answer = Day05().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(125_742_456L)
        }
    }

}