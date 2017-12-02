package lt.setkus.advenofcode2017.day2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpreadsheetTest {

    @Test
    public void whenSpreadsheetProvided_ThenShouldCalculateCheckSum() {
        int[][] spreadSheet = {{5, 1, 9, 5}, {7, 5, 3}, {2, 4, 6, 8}};
        Spreadsheet spreadsheet = new Spreadsheet(spreadSheet);
        assertEquals(18, spreadsheet.checkSum());
    }

    @Test
    public void whenSpreadsheetProvided_ThenShouldCalculateTheSumOfEachRowsDivisibleNumber() throws Exception {
        int[][] spreadsheetMatrix = {{5, 9, 2, 8}, {9, 4, 7, 3}, {3, 8, 6, 5}};
        Spreadsheet spreadsheet = new Spreadsheet(spreadsheetMatrix);
        assertEquals(9, spreadsheet.evenlyDivisibleSum());
    }
}