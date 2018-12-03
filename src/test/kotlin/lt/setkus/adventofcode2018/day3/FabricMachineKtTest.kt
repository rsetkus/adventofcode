package lt.setkus.adventofcode2018.day3

import junit.framework.TestCase.assertEquals
import lt.setkus.adventofcode2018.readFileToList
import org.junit.Test
import java.io.File

class FabricMachineKtTest {

    @Test
    fun testOverlap() {
        assertEquals(4, calculateOverlap(mutableListOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")))
        assertEquals(4, calculateOverlap(File("2018/day3/input1").readFileToList()))
    }
}