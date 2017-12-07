package lt.setkus.advenofcode2017.day5;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static lt.setkus.advenofcode2017.day5.InstructionsExecutor.Mode.*;
import static org.junit.Assert.assertEquals;

public class InstructionsExecutorTest {

    @Test
    public void whenGivenALisOfStepInstruction_ThenShouldReturnNumberOfExecutedStepsBeforeLeavingTheList() {
        List<Integer> instructions = Stream.of(0, 3, 0, 1, -3).collect(toList());
        assertEquals(5, new InstructionsExecutor(NORMAL).execute(instructions));
    }

    @Test
    public void whenGivenALisOfStepInstructionsAndModeStrange_ThenShouldIncreaseStepsDifferently() {
        List<Integer> instructions = Stream.of(0, 3, 0, 1, -3).collect(toList());
        assertEquals(10, new InstructionsExecutor(STRANGE).execute(instructions));
    }
}