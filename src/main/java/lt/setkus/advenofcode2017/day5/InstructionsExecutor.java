package lt.setkus.advenofcode2017.day5;

import java.util.List;

public class InstructionsExecutor {

    public static int execute(List<Integer> instructions) {
        int steps = 0;
        int currentPosition = 0;
        while (true) {
            int instruction = instructions.get(currentPosition);
            currentPosition += instruction;
            if (currentPosition < instructions.size() && currentPosition >= 0) {
                instructions.set(currentPosition, instructions.get(currentPosition) + 1);
                steps++;
            } else {
                break;
            }
        }
        return steps;
    }
}
