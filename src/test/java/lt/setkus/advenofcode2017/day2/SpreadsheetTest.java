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
}