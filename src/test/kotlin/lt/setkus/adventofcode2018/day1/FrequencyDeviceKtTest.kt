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
        assertEquals(435, frequencyResult(mutableListOf<Int>().loadFromFile("2018/day1/input1").toTypedArray()))
    }

    @Test
    fun testDuplicateFrequency() {
        assertEquals(0, duplicateFrequencyResult(arrayOf(+1, -1)))
        assertEquals(10, duplicateFrequencyResult(arrayOf(+3, +3, +4, -2, -4)))
        assertEquals(14, duplicateFrequencyResult(arrayOf(+7, +7, -2, -7, -4)))
        assertEquals(0, duplicateFrequencyResult(mutableListOf<Int>().loadFromFile("2018/day1/input2").toTypedArray()))
    }
}
