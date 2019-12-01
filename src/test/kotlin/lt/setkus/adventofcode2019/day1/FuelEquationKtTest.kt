package lt.setkus.adventofcode2019.day1

import junit.framework.TestCase.assertEquals
import lt.setkus.adventofcode2018.readFileToList
import org.junit.Test
import java.io.File

class FuelEquationKtTest {

    @Test
    fun `test example data`() {
        assertEquals(calculateFuelAmount(listOf(12)), 2)
        assertEquals(calculateFuelAmount(listOf(14)), 2)
        assertEquals(calculateFuelAmount(listOf(1969)), 654)
        assertEquals(calculateFuelAmount(listOf(100756)), 33583)
    }

    @Test
    fun `test puzzle data`() {
        val masses: List<Int> = File("2019/day1/input1").readFileToList().map { it.toInt() }
        assertEquals(calculateFuelAmount(masses), 3506577)
    }

    @Test
    fun `test example data including fuel mass`() {
        assertEquals(calculateFuelAmountIncludingFuelItself(listOf(12)), 2)
        assertEquals(calculateFuelAmountIncludingFuelItself(listOf(1969)), 966)
        assertEquals(calculateFuelAmountIncludingFuelItself(listOf(100756)), 50346)
    }

    @Test
    fun `test puzzle data when fuel included`() {
        val masses: List<Int> = File("2019/day1/input2").readFileToList().map { it.toInt() }
        assertEquals(calculateFuelAmountIncludingFuelItself(masses), 5256960)
    }
}