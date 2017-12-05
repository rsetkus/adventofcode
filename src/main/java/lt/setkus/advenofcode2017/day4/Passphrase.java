package lt.setkus.advenofcode2017.day4;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class Passphrase {

    private static ToIntFunction<char[]> toProductOfChars = chars -> {
        int product = 1;
        for (char c : chars) {
            product *= c;
        }
        return product;
    };

    public static boolean simpleValidation(String input) {
        String[] elements = input.split(" ");
        long numberOfDistinctElements = Arrays.stream(elements).distinct().count();
        return elements.length == numberOfDistinctElements;
    }

    public static boolean enhancedValidation(String input) {
        String[] elements = input.split(" ");
        long numberOfUniqueElements = Arrays.stream(elements)
                .map(String::toCharArray)
                .mapToInt(toProductOfChars)
                .distinct()
                .count();
        return elements.length == numberOfUniqueElements;
    }

    public static void main(String[] args) {
        URL url = Passphrase.class.getClassLoader().getResource("day4/input1.txt");

        try (Stream<String> stringStream = Files.lines(Paths.get(URI.create(url.toString())))) {
            long numberOfValidPassphrases = stringStream
                    .filter(Passphrase::simpleValidation)
                    .count();

            System.out.printf("Found %d valid passphrases.\n", numberOfValidPassphrases);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> stringStream = Files.lines(Paths.get(URI.create(url.toString())))) {
            long numberAnagramsExcluded = stringStream
                    .filter(Passphrase::enhancedValidation)
                    .count();

            System.out.printf("Found %d valid passphrases with enhanced security.", numberAnagramsExcluded);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
