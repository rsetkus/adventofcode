package lt.setkus.adventofcode2018.day5

import junit.framework.TestCase.assertEquals
import org.junit.Test

class Day5Test {

    @Test
    fun testPolymerAdjancent() {
        assertEquals(10, Day5("dabAcCaCBAcCcaDA").removeOppositePolarity().length)
    }
}