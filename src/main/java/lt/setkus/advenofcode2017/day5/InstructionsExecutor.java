package lt.setkus.advenofcode2017.day5;

import lt.setkus.advenofcode2017.day4.Passphrase;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static lt.setkus.advenofcode2017.day5.InstructionsExecutor.Mode.NORMAL;
import static lt.setkus.advenofcode2017.day5.InstructionsExecutor.Mode.STRANGE;

public class InstructionsExecutor {

    private final Mode mode;

    public InstructionsExecutor(Mode mode) {
        this.mode = mode;
    }

    public enum Mode {
        STRANGE, NORMAL
    }

    public int execute(List<Integer> instructions) {
        int steps = 0;
        int currentPosition = 0;
        while (currentPosition < instructions.size() && currentPosition >= 0) {
            steps++;
            int offset = instructions.get(currentPosition);
            int nextOffset = (mode.equals(STRANGE) && offset > 2) ? -1 : 1;
            instructions.set(currentPosition, offset + nextOffset);
            currentPosition += offset;
        }
        return steps;
    }

    public static void main(String[] args) {
        URL url = Passphrase.class.getClassLoader().getResource("day5/input1.txt");

        try (Stream<String> stringStream = Files.lines(Paths.get(URI.create(url.toString())))) {
            List<Integer> instructions = stringStream.map(Integer::valueOf).collect(toList());
            System.out.printf("Instructions executed in %d steps.\n", new InstructionsExecutor(NORMAL).execute(new ArrayList<>(instructions)));
            System.out.printf("Strange instructions executed in %d steps.", new InstructionsExecutor(STRANGE).execute(new ArrayList<>(instructions)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
