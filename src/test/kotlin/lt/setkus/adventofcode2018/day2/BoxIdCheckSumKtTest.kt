package lt.setkus.adventofcode2018.day2

import junit.framework.TestCase.assertEquals
import lt.setkus.adventofcode2018.readFileToList
import org.junit.Test
import java.io.File

class BoxIdCheckSumKtTest {

    @Test
    fun testCheckSum() {
        assertEquals(12, checkSum(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")))
        assertEquals(5727, checkSum(File("2018/day2/input1").readFileToList()))
    }

    @Test
    fun testCommonLettersBetweenIds() {
        assertEquals("fgij", findCommonLetters(listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")))
        assertEquals("uwfmdjxyxlbgnrotcfpvswaqh", findCommonLetters(File("2018/day2/input1").readFileToList()))
    }
}