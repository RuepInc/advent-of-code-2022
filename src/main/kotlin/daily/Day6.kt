package daily

import general.AbstractPuzzle
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Path
import kotlin.io.path.readText

class Day6: AbstractPuzzle() {
    override fun part1(input: Path): String {
        return part1(input.readText())
    }

    private fun part1(input: String): String {
        return input
            .windowed(4)
            .indexOfFirst { it.chars().distinct().count() == 4L }.plus(4)
            .toString()
    }

    override fun part2(input: Path): String {
        return part2(input.readText())
    }

    private fun part2(input: String): String {
        return input
            .windowed(14)
            .indexOfFirst { it.chars().distinct().count() == 14L }.plus(14)
            .toString()
    }


    @Test
    fun additionalTestsPart1() {
        Assertions.assertEquals("5", part1("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        Assertions.assertEquals("6", part1("nppdvjthqldpwncqszvftbrmjlhg"))
        Assertions.assertEquals("10", part1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        Assertions.assertEquals("11", part1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun additionalTestsPart2() {
        Assertions.assertEquals("23", part2("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        Assertions.assertEquals("23", part2("nppdvjthqldpwncqszvftbrmjlhg"))
        Assertions.assertEquals("29", part2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        Assertions.assertEquals("26", part2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }


    override fun getTestSolutionPart1(): String {
        return "7"
    }

    override fun getTestSolutionPart2(): String {
        return "19"
    }
}