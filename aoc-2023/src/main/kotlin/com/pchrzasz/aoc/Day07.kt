package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day07 {

    fun solvePart1(lines: List<String>): Int = solve(lines, false)

    fun solvePart2(lines: List<String>): Int = solve(lines, true)

    private fun solve(lines: List<String>, withJoker: Boolean) =
        lines
            .map { row -> row.split(" ") }
            .map {
                val identity = when (withJoker) {
                    true -> calculateIdentity(it.first(), RANKS_WITH_JOKERS, this::calculateCategoryWithJokers)
                    false -> calculateIdentity(it.first(), RANKS, this::calculateCategoryWithoutJokers)
                }
                Hand(it.last().toInt(), identity)
            }
            .sorted()
            .mapIndexed { index, hand -> hand.bid * (index + 1) }
            .sum()

    private class Hand(val bid: Int, val identity: Long) : Comparable<Hand> {
        override fun compareTo(other: Hand): Int =
            this.identity.compareTo(other.identity)
    }

    private fun calculateIdentity(
        cards: String,
        strength: String,
        categoryCalculation: (String) -> List<Int>
    ): Long {
        val category = CATEGORIES.indexOf(categoryCalculation(cards))
        val cardValues = cards.map { strength.indexOf(it).let { if (it < 10) "0$it" else it.toString() } }
            .joinToString("") { it }
        return "$category$cardValues".toLong()
    }

    private fun calculateCategoryWithoutJokers(cards: String): List<Int> =
        cards.groupingBy { it }.eachCount().values.sortedDescending()

    private fun calculateCategoryWithJokers(cards: String): List<Int> {
        val cardsWithoutJokers = cards.filterNot { it == 'J' }
        val numberOfJokers = cards.length - cardsWithoutJokers.length

        return calculateCategoryWithoutJokers(cardsWithoutJokers).toMutableList().apply {
            if (this.isEmpty()) add(0, 5) else this[0] += numberOfJokers
        }
    }

    companion object {
        private const val RANKS = "23456789TJQKA"
        private const val RANKS_WITH_JOKERS = "J23456789TQKA"
        private val CATEGORIES = listOf(
            listOf(1, 1, 1, 1, 1),
            listOf(2, 1, 1, 1),
            listOf(2, 2, 1),
            listOf(3, 1, 1),
            listOf(3, 2),
            listOf(4, 1),
            listOf(5)
        )
    }

}
