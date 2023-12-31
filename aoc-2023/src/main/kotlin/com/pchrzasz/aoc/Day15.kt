package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day15 {

    fun solvePart1(lines: List<String>): Int =
        lines[0].split(",").sumOf { hash(it) }

    fun solvePart2(lines: List<String>): Int =
        lines[0]
            .split(",")
            .fold(mutableMapOf<Int, LinkedHashMap<String, Int>>()) { boxes, step ->
                val parts = step.split("=")
                if (parts.size == 2) {
                    val (label, focalLength) = parts
                    val key = hash(label)
                    boxes.computeIfAbsent(key) { linkedMapOf() }
                    boxes[key]?.put(label, focalLength.toInt())
                } else {
                    val label = step.split("-")[0]
                    val key = hash(label)
                    boxes[key]?.remove(label)
                }
                boxes
            }.map { (boxNumber, box) ->
                box.values.withIndex().sumOf { (index, focalLength) ->
                    (1 + boxNumber) * (index + 1) * focalLength
                }
            }.sumOf { it }

    private fun hash(step: String): Int =
        step.fold(0) { acc, char ->
            ((acc + char.code) * 17) % 256
        }


}
