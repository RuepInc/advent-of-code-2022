package daily

import general.AbstractPuzzle
import java.nio.file.Path
import kotlin.io.path.readLines

class Day4: AbstractPuzzle() {
    override fun part1(input: Path): String {
        val map = input.readLines()
            .chunked(2)
            .map {
                it.map {
                    val sections = it.split(",")
                    val s1 = sections[0].split("-").map { it.toInt() }
                    val s2 = sections[1].split("-").map { it.toInt() }
                    if ((s1[0]>=s2[0] && s1[1]<=s2[1]) || (s2[0]>=s1[0] && s2[1]<=s1[1])) {
                        1
                    } else
                        0
                }.sum()
            }.sum()
        return map.toString()


    }

    override fun part2(input: Path): String {
        val map = input.readLines()
            .chunked(2)
            .map {
                it.map {
                    val sections = it.split(",")
                    val s1 = sections[0].split("-").map { it.toInt() }
                    val s2 = sections[1].split("-").map { it.toInt() }
                    val sections1 = s1[0]..s1[1]
                    val sections2 = s2[0]..s2[1]
                    if (sections1.any { sections2.contains(it) } || sections2.any { sections1.contains(it) }) {
                        1
                    } else
                        0
                }.sum()
            }.sum()
        return map.toString()

    }

    override fun getTestSolutionPart1(): String {
        return "2"
    }

    override fun getTestSolutionPart2(): String {
        return "4"
    }
}