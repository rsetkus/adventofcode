package lt.setkus.advenofcode2017.day4;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Passphrase {
    public static boolean isValidPassphrase(String input) {
        String[] elements = input.split(" ");
        long numberOfDistinctElements = Arrays.stream(elements).distinct().count();
        return elements.length == numberOfDistinctElements;
    }

    public static void main(String[] args) {
        URL url = Passphrase.class.getClassLoader().getResource("input1.txt");

        try (Stream<String> stringStream = Files.lines(Paths.get(URI.create(url.toString())))) {
            long numberOfValidPassphrases = stringStream
                    .peek(System.out::println)
                    .filter(Passphrase::isValidPassphrase)
                    .count();

            System.out.printf("Found %d valid passphrases.", numberOfValidPassphrases);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
