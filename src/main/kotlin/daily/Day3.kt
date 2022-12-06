package daily

import general.AbstractPuzzle
import java.nio.file.Path
import kotlin.io.path.readLines

class Day3: AbstractPuzzle() {
    override fun part1(input: Path): String {
        return input.readLines().map {
            val firstHalf = it.substring(0, it.length / 2)
            val secondHalf = it.substring(it.length / 2)
            val common = firstHalf.toList().intersect(secondHalf.toList())
            common.first().priority()
        }.sum().toString()
    }

    override fun part2(input: Path): String {
        val l = input.readLines()
            .chunked(3)
        val r = l.map {
            val common = it[0].toList().intersect(it[1].toList()).intersect(it[2].toList())
            common.first().priority()

        }.sum()
        return r.toString()
    }

    private fun Char.priority(): Int {
        return if (this.isUpperCase()) {
            this.code.minus(38)
        } else {
            this.code.minus(96)
        }
    }

    override fun getTestSolutionPart1(): String {
        return "157"
    }

    override fun getTestSolutionPart2(): String {
        return "70"
    }
}