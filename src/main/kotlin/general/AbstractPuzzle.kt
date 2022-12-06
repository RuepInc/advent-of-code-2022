package general

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Path

abstract class AbstractPuzzle : Puzzle {

    override fun getTestInput(): Path {
        val day = this::class.java.simpleName
        val resource = this::class.java.classLoader.getResource("$day/testinput.txt")
        return Path.of(resource!!.toURI())
    }

    override fun getPuzzleInput(): Path {
        val day = this::class.java.simpleName
        val resource = this::class.java.classLoader.getResource("$day/puzzleinput.txt")
        return Path.of(resource!!.toURI())
    }

    @Test
    fun testPart1() {
        Assertions.assertEquals(getTestSolutionPart1(), part1(getTestInput()))
    }

    @Test
    fun testPart2() {
        Assertions.assertEquals(getTestSolutionPart2(), part2(getTestInput()))
    }

    @Test
    fun printPart1() {
        println(part1(getPuzzleInput()))
    }

    @Test
    fun printPart2() {
        println(part2(getPuzzleInput()))
    }

}