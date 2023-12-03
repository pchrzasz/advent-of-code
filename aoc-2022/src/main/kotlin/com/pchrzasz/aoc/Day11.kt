package com.pchrzasz.aoc


class Day11 {
    fun solvePart1(input: String): Long {
        val monkeys = parseInput(input)
        repeat(20) {
            monkeys.forEach {
                it.processItems(monkeys) { num -> num / 3 }
            }
        }
        return monkeys.map { it.processedItems }.sortedDescending().take(2).reduce(Long::times)
    }

    fun solvePart2(input: String): Long {
        val monkeys = parseInput(input)
        val testProduct: Long = monkeys.map { it.divisible }.reduce(Long::times)
        repeat(10_000) {
            monkeys.forEach {
                it.processItems(monkeys) { num ->
                    num % testProduct
                }
            }
        }
        return monkeys.map { it.processedItems }.sortedDescending().take(2).reduce(Long::times)
    }

    private fun parseInput(input: String): List<Monkey> {
        return input.split("\n\n").map { it.lines() }.map {
            val numberMonkey = it[0].substringAfter(" ").substringBefore(":").toInt()
            val items = it[1].substringAfter(":").split(",").map { k -> k.trim().toLong() }.toMutableList()
            val operation: (Long) -> Long = parseOperation(it[2])
            val divisible = it[3].substringAfter("by ").toLong()
            val ifMonkey = it[4].substringAfter("monkey ").toInt()
            val elseMonkey = it[5].substringAfter("monkey ").toInt()
            Monkey(numberMonkey, items, divisible, operation, ifMonkey, elseMonkey)
        }
    }

    private fun parseOperation(operation: String): (Long) -> Long {
        when {
            operation.contains("+") -> {
                return { num -> num + operation.substringAfter("+ ").toLong() }
            }

            operation.contains("*") -> {
                val arg = operation.substringAfter("* ")
                if (arg == "old") return { num -> num * num }
                else return { num -> num * arg.toLong() }
            }

            else -> throw IllegalArgumentException("Unknown Direction")
        }
    }

    class Monkey(
        private val number: Int,
        private val items: MutableList<Long>,
        val divisible: Long,
        private val operation: (Long) -> Long,
        private val ifMonkey: Int,
        private val elseMonkey: Int
    ) {

        var processedItems: Long = 0
        fun processItems(monkeys: List<Monkey>, worryLevel: (Long) -> Long) {
            val iter = items.iterator()
            while (iter.hasNext()) {
                val operated = operation(iter.next())
                val worry = worryLevel(operated)
                val target = if (worry.mod(divisible) == 0L) ifMonkey else elseMonkey
                monkeys[target].items.add(worry)
                iter.remove()
                processedItems += 1
            }
        }

        override fun toString(): String {
            return "Monkey $number: $items"
        }

    }

}