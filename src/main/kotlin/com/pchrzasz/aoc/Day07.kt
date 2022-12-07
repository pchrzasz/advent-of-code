package com.pchrzasz.aoc

class Day07 {
    fun solvePart1(input: String): Int =
        parseInput(input).find { it.size <= 100_000 }.sumOf { it.size }

    fun solvePart2(input: String): Int {
        val rootDirectory = parseInput(input)
        val unusedSpace = 70_000_000 - rootDirectory.size
        val deficit = 30_000_000 - unusedSpace
        return rootDirectory.find { it.size >= deficit }.minBy { it.size }.size
    }

    private fun parseInput(input: String): Directory {
        val callStack = ArrayDeque<Directory>().apply { add(Directory("/")) }
        input.lines().forEach { item ->
            when {
                item == "$ ls" -> {}
                item.startsWith("dir") -> {}
                item == "$ cd /" -> callStack.removeIf { it.name != "/" }
                item == "$ cd .." -> callStack.removeFirst()
                item.startsWith("$ cd") -> {
                    val subPath = item.substringAfterLast(" ")
                    callStack.addFirst(callStack.first().traverse(subPath))
                }

                else -> {
                    val size = item.substringBefore(" ").toInt()
                    callStack.first().addFile(size)
                }
            }
        }
        return callStack.last()
    }

    private class Directory(val name: String) {
        private val subDirs: MutableMap<SubPath, Directory> = mutableMapOf()
        private var sizeOfFiles: Int = 0

        val size: Int
            get() = sizeOfFiles + subDirs.values.sumOf { it.size }

        fun addFile(size: Int) {
            sizeOfFiles += size
        }

        fun traverse(dir: SubPath): Directory =
            subDirs.getOrPut(dir) { Directory(dir) }

        fun find(predicate: (Directory) -> Boolean): List<Directory> =
            subDirs.values.filter(predicate) +
                    subDirs.values.flatMap { it.find(predicate) }
    }
}

typealias SubPath = String