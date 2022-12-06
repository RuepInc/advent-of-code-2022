package general

import java.nio.file.Path

interface Puzzle {

    fun part1(input: Path): String
    fun part2(input: Path): String

    fun getTestSolutionPart1(): String
    fun getTestSolutionPart2(): String

    fun getTestInput(): Path
    fun getPuzzleInput(): Path

}