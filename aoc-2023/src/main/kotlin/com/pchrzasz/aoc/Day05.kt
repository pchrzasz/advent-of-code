package com.pchrzasz.aoc

/**
 * @author Paweł Chrząszczewski
 */
class Day05 {

    fun solvePart1(lines: List<String>): Long = solution1(seeds(lines[0]), parseMaps(lines))

    fun solvePart2(lines: List<String>): Long =
        solution2(
            seeds(lines[0])
                .chunked(2)
                .map {
                    (it[0] until it[0] + it[1])
                },
            parseMaps(lines).reversed().map { it.map { it.second to it.first } }
        )


    private fun seeds(row: String): List<Long> = row.substringAfter(":").trim().split(" ").map { it.toLong() }

    private fun parseMaps(lines: List<String>) =
        lines
            .filter { it.isNotBlank() }
            .drop(1)
            .fold(mutableListOf<MutableList<Pair<LongRange, LongRange>>>()) { seedsInformation, line ->
                if (getMapTypes(line) != null) {
                    seedsInformation.add(mutableListOf())
                } else {
                    val nums = line.split(" ").map { it.toLong() }
                    val fromTo = Pair((nums[1] until nums[1] + nums[2]), (nums[0] until nums[0] + nums[2]))
                    seedsInformation.last().add(fromTo)
                }
                seedsInformation
            }


    private fun solution1(seeds: List<Long>, maps: List<List<Pair<LongRange, LongRange>>>): Long =
        seeds.minOf { seed ->
            maps.fold(seed) { acc, pair ->
                pair.firstOrNull { acc in it.first }
                    .let { if (it != null) it.second.first + (acc - it.first.first) else acc }
            }
        }

    private fun solution2(seeds: List<LongRange>, maps: List<List<Pair<LongRange, LongRange>>>): Long =
        generateSequence(0L, Long::inc).first {
            val seed = maps.fold(it) { acc, pair ->
                pair.firstOrNull { acc in it.first }
                    .let { if (it != null) it.second.first + (acc - it.first.first) else acc }
            }
            seeds.any { seed in it }
        }


    private fun getMapTypes(line: String): Pair<Type, Type>? {
        val mapRegex = Regex("""(.+)-to-(.+)\s+map:""")
        val matchResult = mapRegex.find(line)
        return matchResult?.let {
            val sourceType = Type.valueOf(it.groupValues[1].uppercase())
            val targetType = Type.valueOf(it.groupValues[2].uppercase())
            Pair(sourceType, targetType)
        }
    }

    private enum class Type {
        SEED, SOIL, FERTILIZER, WATER, LIGHT, TEMPERATURE, HUMIDITY, LOCATION
    }

}
