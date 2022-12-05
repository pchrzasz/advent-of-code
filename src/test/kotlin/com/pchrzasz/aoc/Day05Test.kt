package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {

    private val input = """
            [D]    
        [N] [C]    
        [Z] [M] [P]
         1   2   3 
        
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day05().solvePart1(input)

            Assertions.assertThat(answer).isEqualTo("CMZ")
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day05.txt")
            val answer = Day05().solvePart1(inputAsText)

            Assertions.assertThat(answer).isEqualTo("FJSRQCFTN")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day05().solvePart2(input)

            Assertions.assertThat(answer).isEqualTo("MCD")
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day05.txt")
            val answer = Day05().solvePart2(inputAsText)

            Assertions.assertThat(answer).isEqualTo("CJVLJQPHS")
        }
    }

}