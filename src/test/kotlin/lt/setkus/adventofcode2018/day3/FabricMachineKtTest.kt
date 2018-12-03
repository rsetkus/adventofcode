package lt.setkus.adventofcode2018.day3

import junit.framework.TestCase.assertEquals
import org.junit.Test

class FabricMachineKtTest {

    @Test
    fun testOverlap() {
        assertEquals(4, calculateOverlape(mutableListOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2")))
    }
}