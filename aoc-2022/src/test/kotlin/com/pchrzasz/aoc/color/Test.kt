package com.pchrzasz.aoc.color

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Test {

    @Test
    fun `Matches example`() {
        assertTrue(isValid("4539 1488 0343 6467"))
        assertFalse(isValid("8273 1232 7352 0569"))
        assertFalse(isValid("8"))
    }

    fun isValid(number: String): Boolean {
        val numberWithoutWhiteSpaces = number.filterNot { it.isWhitespace() }
        return when {
            numberWithoutWhiteSpaces.length <= 1 -> false
            else -> numberWithoutWhiteSpaces
                .mapIndexed<Int> { idx, value ->
                    if (idx % 2 == 0) {
                        val w = value.toString().toInt() * 2
                        if (w > 9) {
                            w - 9
                        } else {
                            w
                        }
                    } else {
                        value.toString().toInt()
                    }
                }
                .sum().let { it % 10 == 0 }
        }
    }
}