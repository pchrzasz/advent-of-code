package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day02 {

    fun solvePart1(row: List<String>): Int =
        row.map { Game.from(it) }
            .filter { isPossible(it) }
            .sumOf {
                it.id
            }

    fun solvePart2(row: List<String>): Int =
        row.map { Game.from(it) }
            .sumOf { it.red * it.green * it.blue }

    private fun isPossible(game: Game): Boolean =
        game.red <= 12 && game.green <= 13 && game.blue <= 14

    private data class Game(val id: Int, val red: Int, val green: Int, val blue: Int) {
        companion object {
            fun from(row: String): Game {
                val id = row.substringAfter("Game ").substringBefore(":").toInt();
                val blue = "\\b(\\d+) blue\\b".toRegex().findAll(row).map { it.groupValues[1].toInt() }.maxOrNull() ?: 0
                val red = "\\b(\\d+) red\\b".toRegex().findAll(row).map { it.groupValues[1].toInt() }.maxOrNull() ?: 0
                val green =
                    "\\b(\\d+) green\\b".toRegex().findAll(row).map { it.groupValues[1].toInt() }.maxOrNull() ?: 0
                return Game(id, red, green, blue)
            }
        }
    }


}