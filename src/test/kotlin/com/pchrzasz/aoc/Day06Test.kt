package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("Day 6")
class Day06Test {

    companion object {
        @JvmStatic
        fun provideDataPart1(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 7),
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 5),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 6),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 10),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 11)
            )
        }

        @JvmStatic
        private fun provideDataPart2(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 19),
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 23),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 23),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 29),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 26)
            )
        }
    }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @ParameterizedTest(name = "given \"{0}\", then it should return {1}")
        @MethodSource("com.pchrzasz.aoc.Day06Test#provideDataPart1")
        fun `Matches example`(input: String, expected: Int) {
            val answer = Day06().solvePart1(input)

            Assertions.assertThat(answer).isEqualTo(expected)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day06.txt")
            val answer = Day06().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo(1658)
        }
    }


    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @ParameterizedTest(name = "given \"{0}\", then it should return {1}")
        @MethodSource("com.pchrzasz.aoc.Day06Test#provideDataPart2")
        fun `Matches example`(input: String, expected: Int) {
            val answer = Day06().solvePart2(input)

            Assertions.assertThat(answer).isEqualTo(expected)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day06.txt")
            val answer = Day06().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo(2260)
        }
    }

}