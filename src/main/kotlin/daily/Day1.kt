package daily

import general.AbstractPuzzle
import java.nio.file.Path
import kotlin.io.path.readLines

class Day1 : AbstractPuzzle() {

    override fun part1(input: Path): String {
        input.readLines().partition { it.isEmpty() }
        return input.readLines()

            .joinToString("_")
            .split("__")
            .maxOfOrNull {
                it.split("_").sumOf { it.toInt() }
            }!!.toString()
    }

    override fun part2(input: Path): String {
        return input.readLines()
            .joinToString("_")
            .split("__")
            .map {
                it.split("_").sumOf { it.toInt() }
            }.sorted()
            .takeLast(3)
            .sum().toString()
    }

    override fun getTestSolutionPart1(): String {
        return "24000"
    }

    override fun getTestSolutionPart2(): String {
        return "45000"
    }
}