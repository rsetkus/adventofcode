package lt.setkus.adventofcode2018.day5

import junit.framework.TestCase.assertEquals
import lt.setkus.adventofcode2018.readFileToList
import org.junit.Test
import java.io.File

class Day5Test {

    @Test
    fun testExamplePolymerAdjancent() {
        assertEquals(10, Day5("dabAcCaCBAcCcaDA").removeOppositePolarity().length)
    }

    @Test
    fun testInputPolymerAdjancent() {
        assertEquals(11118, Day5(File("2018/day5/input1").readFileToList().first()).removeOppositePolarity().length)
    }
}