package com.pchrzasz.aoc

private const val PATH_TO_INPUT_FILE = "/day2/input.txt"

class Day02 {

    fun solvePart1(input: String): Int = input.lines()
        .map { it.split(" ") }.sumOf {
            val leftHand = AbbrevationToHand.valueOf(it[0]).hand
            val rightHand = AbbrevationToHand.valueOf(it[1]).hand
            rightHand.score(leftHand)
        }

    fun solvePart2(input: String): Int = input.lines()
        .map { it.split(" ") }.sumOf {
            val leftHand = AbbrevationToHand.valueOf(it[0]).hand
            val expectedResult = AbbrevationToResult.valueOf(it[1]).result
            expectedResult.score(leftHand)
        }
}

private enum class GameResult(internal val score: Int) {
    WIN(6) {
        override fun score(hand: Hand): Int {
            val winningHand = Hand.values().first { it.beats == hand.ordinal }
            return this.score + winningHand.score
        }
    },
    LOSE(0) {
        override fun score(hand: Hand): Int {
            val loosingHand = Hand.values()[hand.beats]
            return this.score + loosingHand.score
        }
    },
    DRAW(3) {
        override fun score(hand: Hand): Int {
            return this.score + hand.score
        }
    };

    abstract fun score(hand: Hand): Int
}

private enum class Hand(internal val score: Int, internal val beats: Int) {
    ROCK(1, 2),
    PAPER(2, 0),
    SCISSORS(3, 1);

    fun score(move: Hand): Int {
        val result = when (move) {
            this -> GameResult.DRAW
            values()[this.beats] -> {
                GameResult.WIN
            }

            else -> {
                GameResult.LOSE
            }
        }
        return result.score + this.score
    }
}

private enum class AbbrevationToHand(internal val hand: Hand) {
    A(Hand.ROCK),
    X(Hand.ROCK),
    B(Hand.PAPER),
    Y(Hand.PAPER),
    C(Hand.SCISSORS),
    Z(Hand.SCISSORS);
}

private enum class AbbrevationToResult(internal val result: GameResult) {
    X(GameResult.LOSE),
    Y(GameResult.DRAW),
    Z(GameResult.WIN);
}
