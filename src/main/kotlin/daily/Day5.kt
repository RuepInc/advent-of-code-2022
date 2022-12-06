package daily

import general.AbstractPuzzle
import java.nio.file.Path
import kotlin.io.path.readLines

class Day5: AbstractPuzzle() {
    override fun part1(input: Path): String {
        val lines = input.readLines()
        val rows =
            lines
                .subList(0, lines.indexOfFirst { it.isBlank() }.minus(1))
                .map { it.chunked(4) }
        val stackCount = rows[0].size
        val stacks = (1..stackCount).map {
            it to ArrayDeque(rows.mapNotNull { row ->
                val crate = row[it.minus(1)].trim()
                if (crate.isBlank()) {
                    null
                } else {
                    crate[1]
                }
            }.reversed())
        }.toMap()
        val operations =
            lines
                .subList(lines.indexOfFirst { it.isBlank() }.plus(1), lines.size)
        operations.forEach {
            val (count, from, to) =
             "\\d+".toRegex().findAll(it).map { it.value.toInt() }.toList()
            repeat(count) {
                val crate = stacks[from]?.removeLast()!!
                stacks[to]?.addLast(crate)
            }
        }
        return stacks.values.map { it.last() }.joinToString("")
    }

    override fun part2(input: Path): String {
        val lines = input.readLines()
        val rows =
            lines
                .subList(0, lines.indexOfFirst { it.isBlank() }.minus(1))
                .map { it.chunked(4) }
        val stackCount = rows[0].size
        val stacks = (1..stackCount).map {
            it to ArrayDeque(rows.mapNotNull { row ->
                val crate = row[it.minus(1)].trim()
                if (crate.isBlank()) {
                    null
                } else {
                    crate[1]
                }
            }.reversed())
        }.toMap()
        val operations =
            lines
                .subList(lines.indexOfFirst { it.isBlank() }.plus(1), lines.size)
        operations.forEach {
            val (count, from, to) =
                "\\d+".toRegex().findAll(it).map { it.value.toInt() }.toList()
            val movedCrates = (0..count.minus(1)).map {
                stacks[from]?.removeLast()!!
            }
            movedCrates.reversed().forEach {
                stacks[to]?.addLast(it)
            }
        }
        return stacks.values.map { it.last() }.joinToString("")
    }

    override fun getTestSolutionPart1(): String {
        return "CMZ"
    }

    override fun getTestSolutionPart2(): String {
        return "MCD"
    }
}