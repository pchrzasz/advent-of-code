package com.pchrzasz.aoc

class Day13 {
    fun solvePart1(input: String): Int {
        val packets = parseInput(input)
        return packets.chunked(2).mapIndexed { index, pair ->
            if (pair.first() < pair.last()) index + 1 else 0
        }.sum()
    }

    fun solvePart2(input: String): Int {
        val packets = parseInput(input)
        val dividerPacket1 = Packet.of("[[2]]")
        val dividerPacket2 = Packet.of("[[6]]")
        val ordered = (packets + dividerPacket1 + dividerPacket2).sorted()
        return (ordered.indexOf(dividerPacket1) + 1) * (ordered.indexOf(dividerPacket2) + 1)
    }

    private fun parseInput(input: String): List<Packet> =
        input.lines().filter { it.isNotBlank() }.map { Packet.of(it) }

    private sealed class Packet : Comparable<Packet> {
        companion object {
            fun of(input: String): Packet =
                of(
                    input.split("""((?<=[\[\],])|(?=[\[\],]))""".toRegex())
                        .filter { it.isNotBlank() }
                        .filter { it != "," }
                        .iterator()
                )

            private fun of(input: Iterator<String>): Packet {
                val packets = mutableListOf<Packet>()
                while (input.hasNext()) {
                    when (val symbol = input.next()) {
                        "]" -> return ListPacket(packets)
                        "[" -> packets.add(of(input))
                        else -> packets.add(IntPacket(symbol.toInt()))
                    }
                }
                return ListPacket(packets)
            }
        }
    }

    private class IntPacket(val amount: Int) : Packet() {
        fun asList(): Packet = ListPacket(listOf(this))

        override fun compareTo(other: Packet): Int =
            when (other) {
                is IntPacket -> amount.compareTo(other.amount)
                is ListPacket -> asList().compareTo(other)
            }
    }

    private class ListPacket(val subPackets: List<Packet>) : Packet() {
        override fun compareTo(other: Packet): Int =
            when (other) {
                is IntPacket -> compareTo(other.asList())
                is ListPacket -> subPackets.zip(other.subPackets)
                    .map { it.first.compareTo(it.second) }
                    .firstOrNull { it != 0 } ?: subPackets.size.compareTo(other.subPackets.size)
            }
    }
}