package daily

import general.AbstractPuzzle
import java.nio.file.Path
import kotlin.io.path.readLines

class Day2: AbstractPuzzle() {
    override fun part1(input: Path): String {
        return input
            .readLines()
            .map {
                when (it) {
//                      A ROCK, B PAPER, C SCISSOR
//                      X ROCK, Y PAPER, Z SCISSOR
                    "A X" -> 4
                    "A Y" -> 8
                    "A Z"-> 3
                    "B X" -> 1
                    "B Y" -> 5
                    "B Z" -> 9
                    "C X" -> 7
                    "C Y" -> 2
                    "C Z" -> 6
                    else -> 0
                }
            }
            .sum().toString()
    }

    override fun part2(input: Path): String {
        return input
            .readLines()
            .map {
                when (it) {
//            A ROCK, B PAPER, C SCISSOR
//            X LOSE, Y DRAW, Z WIN
                    "A X" -> 3
                    "A Y" -> 4
                    "A Z"-> 8
                    "B X" -> 1
                    "B Y" -> 5
                    "B Z" -> 9
                    "C X" -> 2
                    "C Y" -> 6
                    "C Z" -> 7
                    else -> 0
                }
            }
            .sum().toString()
    }

    override fun getTestSolutionPart1(): String {
        return "15"
    }

    override fun getTestSolutionPart2(): String {
        return "12"
    }
}