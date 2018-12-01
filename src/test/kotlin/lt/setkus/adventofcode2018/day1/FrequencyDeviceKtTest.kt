package lt.setkus.adventofcode2018.day1

import junit.framework.Assert.assertEquals
import lt.setkus.adventofcode2018.loadFromFile
import org.junit.Test

class FrequencyDeviceKtTest {

    @Test
    fun testFrequencyInput() {
        assertEquals(3, frequencyResult(arrayOf(+1, -2, +3, +1)))
        assertEquals(3, frequencyResult(arrayOf(+1, +1, +1)))
        assertEquals(0, frequencyResult(arrayOf(+1, +1, -2)))
        assertEquals(-6, frequencyResult(arrayOf(-1, -2, -3)))
    }

    @Test
    fun testPuzzleFrequency() {
        assertEquals(435, frequencyResult(mutableListOf<Int>().loadFromFile("2018/day1/input").toTypedArray()))
    }
}
