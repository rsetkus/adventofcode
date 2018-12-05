package lt.setkus.adventofcode2018.day4

import junit.framework.TestCase.assertEquals
import lt.setkus.adventofcode2018.readFileToList
import org.junit.Test
import java.io.File

class Day4Test {

    val exampleRecords = listOf(
            "[1518-11-01 00:05] falls asleep",
            "[1518-11-01 00:00] Guard #10 begins shift",
            "[1518-11-01 00:25] wakes up",
            "[1518-11-01 00:30] falls asleep",
            "[1518-11-01 00:55] wakes up",
            "[1518-11-01 23:58] Guard #99 begins shift",
            "[1518-11-02 00:40] falls asleep",
            "[1518-11-02 00:50] wakes up",
            "[1518-11-03 00:05] Guard #10 begins shift",
            "[1518-11-03 00:24] falls asleep",
            "[1518-11-03 00:29] wakes up",
            "[1518-11-04 00:02] Guard #99 begins shift",
            "[1518-11-04 00:36] falls asleep",
            "[1518-11-04 00:46] wakes up",
            "[1518-11-05 00:03] Guard #99 begins shift",
            "[1518-11-05 00:45] falls asleep",
            "[1518-11-05 00:55] wakes up"
    )

    @Test
    fun testStrategyOneWithExampleRecords() {
        assertEquals(240, Day4(exampleRecords).strategyOne())
    }

    @Test
    fun testStrategyOneWithInputRecords() {
        assertEquals(142515, Day4(File("2018/day4/input1").readFileToList()).strategyOne())
    }

    @Test
    fun testStrategyTwoWithExampleRecords() {
        assertEquals(4455, Day4(exampleRecords).strategyTwo())
    }

    @Test
    fun testStrategyTwoWithInputRecords() {
        assertEquals(5370, Day4(File("2018/day4/input2").readFileToList()).strategyTwo())
    }
}





