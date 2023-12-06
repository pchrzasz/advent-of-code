package com.pchrzasz.aoc

import kotlinx.coroutines.*

/**
 * @author Paweł Chrząszczewski
 */
class Day05 {

    fun solvePart1(lines: List<String>): Long = runBlocking { solution(listOf(seeds(lines[0]).asSequence()), lines) }

    // super dummy
    fun solvePart2(lines: List<String>): Long = runBlocking {
        solution(
            seeds(lines[0])
                .chunked(2)
                .map {
                    (it[0] until it[0] + it[1])
                        .asSequence()
                },
            lines
        )
    }


    private fun seeds(row: String): List<Long> = row.substringAfter(":").trim().split(" ").map { it.toLong() }
    private suspend fun solution(seeds: List<Sequence<Long>>, lines: List<String>): Long {
        val mappings = listOf(
            Type.SEED to Type.SOIL,
            Type.SOIL to Type.FERTILIZER,
            Type.FERTILIZER to Type.WATER,
            Type.WATER to Type.LIGHT,
            Type.LIGHT to Type.TEMPERATURE,
            Type.TEMPERATURE to Type.HUMIDITY,
            Type.HUMIDITY to Type.LOCATION
        )
        var current: Pair<Type, Type>? = null
        val maps =
            lines.filter { it.isNotBlank() }
                .drop(1)
                .fold(mutableMapOf<Type, Map<Type, MutableList<Pair<LongRange, LongRange>>>>()) { seedsInformation, line ->
                    val mapTypes = getMapTypes(line)
                    current = mapTypes ?: current
                    if (mapTypes != null) {
                        seedsInformation[mapTypes.first] = mutableMapOf(mapTypes.second to mutableListOf())
                    } else {
                        val nums = line.split(" ").map { it.toLong() }
                        val fromTo = Pair((nums[1] until nums[1] + nums[2]), (nums[0] until nums[0] + nums[2]))
                        seedsInformation[current?.first]?.get(current?.second)?.add(fromTo)
                    }
                    seedsInformation
                }
        return coroutineScope {
            seeds.map {
                async(Dispatchers.Default) {
                    println("Dupax: $it")
                    it.minOf { seed ->
                        mappings.fold(seed) { acc, pair ->
                            maps[pair.first]?.get(pair.second)?.firstOrNull { acc in it.first }.let {
                                if (it != null) it.second.first + (acc - it.first.first)
                                else acc
                            }
                        }
                    }.let {
                        it
                    }
                }
            }.toList().awaitAll().min()
        }
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
