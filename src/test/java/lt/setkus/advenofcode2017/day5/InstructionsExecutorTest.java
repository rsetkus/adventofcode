package lt.setkus.advenofcode2017.day5;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class InstructionsExecutorTest {

    @Test
    @Ignore
    public void WhenGivenALisOfStepInstruction_ThenShouldReturnNumberOfExecutedStepsBeforeLeavingTheList() {
        List<Integer> instructions = Stream.of(0, 3, 0, 1, -3).collect(toList());
        assertEquals(5, InstructionsExecutor.execute(instructions));
    }
}