package lt.setkus.advenofcode2017.day3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpiralTest {

    @Test
    public void whenGivenEntryDigit_ThenShouldCalculateShortestStepsToStart() {
        Spiral spiral = new Spiral(270000);
        assertEquals(0, spiral.manhattanDistanceFrom(1));
        assertEquals(3, spiral.manhattanDistanceFrom(12));
        assertEquals(2, spiral.manhattanDistanceFrom(23));
        assertEquals(31, spiral.manhattanDistanceFrom(1024));
    }

    @Test
    public void whenGivenAdjacentSquaresSumGridAndInputValue_ThenShouldReturnFirstLargerValue() {
        Spiral spiral = new Spiral(25);
        assertEquals(4, spiral.nextLargerValue(2));
        assertEquals(10, spiral.nextLargerValue(5));
    }
}