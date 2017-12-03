package lt.setkus.advenofcode2017.day3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralTest {

    public Spiral spiral;

    @Before
    public void setUp() {
        spiral = new Spiral(270000);
    }

    @Test
    public void whenGivenEntryDigit_ThenShouldCalculateShortestStepsToStart() {
        assertEquals(0, spiral.manhattanDistanceFrom(1));
        assertEquals(3, spiral.manhattanDistanceFrom(12));
        assertEquals(2, spiral.manhattanDistanceFrom(23));
        assertEquals(31, spiral.manhattanDistanceFrom(1024));
    }

    @Test
    public void whenGivenAdjacentSquaresSumGridAndInputValue_ThenShouldReturnFirstLargerValue() {
        assertEquals(4, spiral.nextLargerValue(2));
    }
}