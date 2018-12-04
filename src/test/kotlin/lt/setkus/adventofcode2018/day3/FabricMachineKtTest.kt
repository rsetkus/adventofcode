package lt.setkus.adventofcode2018.day3

import junit.framework.TestCase.assertEquals
import lt.setkus.adventofcode2018.readFileToList
import org.junit.Test
import java.io.File

class FabricMachineKtTest {

    @Test
    fun testOverlap() {
        assertEquals(4, calculateOverlap(mutableListOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")))
        assertEquals(3, calculateOverlap(mutableListOf("#1 @ 0,4: 3x2", "#2 @ 1,3: 2x2", "#3 @ 4,1: 3x2", "#4 @ 6,2: 2x2")))
        assertEquals(120419, calculateOverlap(File("2018/day3/input1").readFileToList()))
    }
}