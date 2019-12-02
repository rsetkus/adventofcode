package lt.setkus.adventofcode2018.day3

import junit.framework.TestCase.assertEquals
import lt.setkus.readFileToList
import org.junit.Test
import java.io.File

class Day3Test {

    @Test
    fun testOverlap() {
        assertEquals(4, Day3(mutableListOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")).calculateOverlap())
        assertEquals(3, Day3(mutableListOf("#1 @ 0,4: 3x2", "#2 @ 1,3: 2x2", "#3 @ 4,1: 3x2", "#4 @ 6,2: 2x2")).calculateOverlap())
        assertEquals(120419, Day3(File("2018/day3/input1").readFileToList()).calculateOverlap())
    }

    @Test
    fun testNonOverlappingClaim() {
        val day3 = Day3(mutableListOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"))
        assertEquals(3, day3.findNonOverlappingId())
    }

    @Test
    fun testNonOverlappingInput() {
        val day3 = Day3(File("2018/day3/input2").readFileToList())
        assertEquals(445, day3.findNonOverlappingId())
    }
}