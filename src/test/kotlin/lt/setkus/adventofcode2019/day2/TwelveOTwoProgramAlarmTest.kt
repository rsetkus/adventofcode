package lt.setkus.adventofcode2019.day2

import junit.framework.TestCase.assertEquals
import lt.setkus.readFileToList
import org.junit.Test
import java.io.File

class TwelveOTwoProgramAlarmTest {

    @Test
    fun `test 1202 program alarm with example data`() {
        assertEquals(2, TwelveOTwoProgramAlarm(listOf(1, 0, 0, 0, 99).toTypedArray()).executeIntcode())
        assertEquals(2, TwelveOTwoProgramAlarm(listOf(2, 3, 0, 3, 99).toTypedArray()).executeIntcode())
        assertEquals(2, TwelveOTwoProgramAlarm(listOf(2, 4, 4, 5, 99, 0).toTypedArray()).executeIntcode())
        assertEquals(30, TwelveOTwoProgramAlarm(listOf(1, 1, 1, 4, 99, 5, 6, 0, 99).toTypedArray()).executeIntcode())
    }

    @Test
    fun `test 1202 program alarm with input data`() {
        val input: List<Int> = File("2019/day2/input1").readFileToList().map { it.split(",") }.flatMap { it }.map { it.toInt() }
        val program = TwelveOTwoProgramAlarm(input.toTypedArray())
        program.restore()
        assertEquals(3716250, program.executeIntcode())
    }
}