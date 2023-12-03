package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day03 {

    fun solvePart1(input: List<String>): Int {
        val map = input.map { line -> line.map { it } }
        return input.mapIndexed { index, line -> index to extractNumbers(line, index) }
            .flatMap { (rowIndex: Int, numbers: List<Number>) ->
                numbers.filter {
                    map.isAdjacent(
                        rowIndex,
                        it.xStart,
                        it.xEnd
                    ) { c -> !c.isDigit() && c != '.' }
                }
            }
            .sumOf { it.number }
    }

    fun solvePart2(input: List<String>): Int {
        val numbers = input.mapIndexed { index, line -> extractNumbers(line, index) }.flatten()
        val symbols = input.mapIndexed { index, line -> extractSymbols(line, index) }.flatten()
        return symbols.sumOf { retrieveGearNumbers(it, numbers) }
    }

    private fun retrieveGearNumbers(symbol: Symbol, numbers: List<Number>): Int {
        val xPositions = setOf(symbol.x - 1, symbol.x, symbol.x + 1)
        val desiredNumbers = numbers.filter { symbol.y - 1 == it.y || symbol.y + 1 == it.y || it.y == symbol.y }
            .filter {
                (symbol.y == it.y && (it.xEnd == symbol.x - 1 || it.xStart == symbol.x + 1)) ||
                        (symbol.y - 1 == it.y && ((it.xStart..it.xEnd).intersect(xPositions).isNotEmpty())) ||
                        (symbol.y + 1 == it.y && ((it.xStart..it.xEnd).intersect(xPositions).isNotEmpty()))
            }.toSet().map { it.number }
        return if (desiredNumbers.size == 2) {
            desiredNumbers[0] * desiredNumbers[1]
        } else 0
    }

    private data class Number(val number: Int, val xStart: Int, val xEnd: Int, val y: Int)

    private fun previousCharNotDigit(index: Int, line: String) = !(index > 0 && line[index - 1].isDigit())

    private fun extractNumbers(line: String, index: Int): List<Number> {
        return line.foldIndexed(mutableListOf()) { startIndex, acc, char ->
            if (previousCharNotDigit(startIndex, line) && char.isDigit()) {
                val endIndex =
                    startIndex + line.substring(startIndex, line.length).takeWhile { it.isDigit() }.length - 1
                val number = line.substring(startIndex, endIndex + 1).toInt()
                acc.add(Number(number, startIndex, endIndex, index))
            }
            acc
        }
    }


    /**
     * This is quick dummy solution, better would be introduction 2D point holding adjacent spots
     */
    private fun List<List<Char>>.isAdjacent(
        y: Int,
        xStart: Int,
        xEnd: Int,
        isSymbol: (Char) -> Boolean
    ): Boolean {
        fun Char.isSymbol(): Boolean = isSymbol(this)

        fun checkTop(x: Int): Boolean =
            y > 0 &&
                    ((x > 0 && this[y - 1][x - 1].isSymbol()) ||
                            this[y - 1][x].isSymbol() ||
                            (x < this[y - 1].size - 1 && this[y - 1][x + 1].isSymbol())
                            )

        fun checkLeft(x: Int): Boolean = x == xStart && x > 0 &&
                this[y][xStart - 1].isSymbol()

        fun checkRight(x: Int): Boolean = x == xEnd && xEnd < this[y].size - 1 &&
                this[y][x + 1].isSymbol()

        fun checkBottom(x: Int): Boolean =
            y < this.size - 1 &&
                    ((x > 0 && this[y + 1][x - 1].isSymbol()) ||
                            this[y + 1][x].isSymbol() ||
                            (x < this[y + 1].size - 1 && this[y + 1][x + 1].isSymbol()))

        return (xStart..xEnd).any {
            checkTop(it) || checkLeft(it) || checkRight(it) || checkBottom(it)
        }
    }

    private data class Symbol(val x: Int, val y: Int, val c: Char)

    private fun extractSymbols(line: String, y: Int): List<Symbol> {
        return line.mapIndexed { x, c -> Symbol(x, y, c) }.filter { it.c == '*' }
    }

}