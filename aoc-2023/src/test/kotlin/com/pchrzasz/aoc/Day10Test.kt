package com.pchrzasz.aoc

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @author Paweł Chrząszczewski
 */
@DisplayName("Day 10")
class Day10Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        private val input = """
            ..F7.
            .FJ|.
            SJ.L7
            |F--J
            LJ...
        """.trimIndent()

        @Test
        fun `Matches example`() {
            val answer = Day10().solvePart1(input.lines())

            Assertions.assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day10.txt")
            val answer = Day10().solvePart1(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(6697)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example 1`() {
            val input1 = """
                ...........
                .S-------7.
                .|F-----7|.
                .||.....||.
                .||.....||.
                .|L-7.F-J|.
                .|..|.|..|.
                .L--J.L--J.
                ...........
            """.trimIndent()
            val answer = Day10().solvePart2(input1.lines())

            Assertions.assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Matches example 2`() {
            val input2 = """
                FF7FSF7F7F7F7F7F---7
                L|LJ||||||||||||F--J
                FL-7LJLJ||||||LJL-77
                F--JF--7||LJLJ7F7FJ-
                L---JF-JLJ.||-FJLJJ7
                |F|F-JF---7F7-L7L|7|
                |FFJF7L7F-JF7|JL---7
                7-L-JL7||F7|L7F-7F7|
                L.L7LFJ|||||FJL7||LJ
                L7JLJL-JLJLJL--JLJ.L
             """.trimIndent()
            val answer = Day10().solvePart2(input2.lines())

            Assertions.assertThat(answer).isEqualTo(10)
        }

        @Test
        fun `Matches example 3`() {
            val input3 = """
                .F----7F7F7F7F-7....
                .|F--7||||||||FJ....
                .||.FJ||||||||L7....
                FJL7L7LJLJ||LJ.L-7..
                L--J.L7...LJS7F-7L7.
                ....F-J..F7FJ|L7L7L7
                ....L7.F7||L7|.L7L7|
                .....|FJLJ|FJ|F7|.LJ
                ....FJL-7.||.||||...
                ....L---J.LJ.LJLJ...
            """.trimIndent()

            val answer = Day10().solvePart2(input3.lines())

            Assertions.assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {
            val inputAsText = Resources.resourceAsText("input_day10.txt")
            val answer = Day10().solvePart2(inputAsText.lines())

            Assertions.assertThat(answer).isEqualTo(423)
        }
    }

}