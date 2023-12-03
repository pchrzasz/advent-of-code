package com.pchrzasz.aoc

import java.util.*

/**
 * @author Paweł Chrząszczewski
 */
fun main() {
    val input = """
        1 2
        2 3
        3 4
        2 4
        1 5
        1 9
        9 10
        5 6
        5 7
        5 8
        8 10
        1 7
    """.trimIndent()

    val nodes = input.lines().map { it.split(" ").map(String::toInt) }.map { Node(it[0], it[1]) }

    val begin = 1
    val end = 10

    println(bfs(begin, end, nodes))
}

private fun bfs(begin: Int, end: Int, nodes: List<Node>): Int {
    val seen = mutableSetOf<Int>()
    val queue = PriorityQueue<PathCost>().apply { add(PathCost(begin, 0)) }
    while (queue.isNotEmpty()) {
        val next = queue.poll()
        if (next.point !in seen) {
            val neighbors = nodes.filter { it.begin == next.point }.map { it.end }
            if (neighbors.contains(end)) return next.cost + 1
            queue.addAll(neighbors.map { PathCost(it, next.cost + 1) })
        }
    }
    throw IllegalStateException("No valid path from $begin to $end")
}

private data class PathCost(val point: Int, val cost: Int) : Comparable<PathCost> {
    override fun compareTo(other: PathCost): Int = this.cost.compareTo(other.cost)

}

private data class Node(val begin: Int, val end: Int)