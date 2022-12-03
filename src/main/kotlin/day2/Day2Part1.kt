package day2

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

private const val PATH_TO_INPUT_FILE = "/day2/input.txt"

fun main() {
    val path = { }.javaClass.getResource(PATH_TO_INPUT_FILE)!!.path
    val file = File(path)
    BufferedReader(FileReader(file)).use { br ->
        var line: String?
        var scorePart1 = 0
        var scorePart2 = 0
        while (br.readLine().also { line = it } != null) {
            val handShapes = line!!.split(" ")
            val leftHand = AbbrevationToHand.valueOf(handShapes[0]).hand
            val rightHand = AbbrevationToHand.valueOf(handShapes[1]).hand
            val expectedResult = AbbrevationToResult.valueOf(handShapes[1]).result
            scorePart1 += rightHand.score(leftHand)
            scorePart2 += expectedResult.score(leftHand)
        }
        println("Result (part1): $scorePart1")
        println("Result (part2): $scorePart2")
    }
}

internal enum class GameResult(internal val score: Int) {
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

internal enum class Hand(internal val score: Int, internal val beats: Int) {
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

internal enum class AbbrevationToHand(internal val hand: Hand) {
    A(Hand.ROCK),
    X(Hand.ROCK),
    B(Hand.PAPER),
    Y(Hand.PAPER),
    C(Hand.SCISSORS),
    Z(Hand.SCISSORS);
}

internal enum class AbbrevationToResult(internal val result: GameResult) {
    X(GameResult.LOSE),
    Y(GameResult.DRAW),
    Z(GameResult.WIN);
}
