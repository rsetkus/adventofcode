package lt.setkus.advenofcode2017.day3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Spiral {

    private final int[][] matrix;
    private final int centerX;
    private final int centerY;
    private final int max;

    private final Map<Integer, Point> mapOfDigits = new HashMap<>();

    public Spiral(int size) {
        int dimension = (int) Math.sqrt(size);
        matrix = new int[dimension][dimension];
        centerX = centerY = dimension / 2;
        max = matrix.length * matrix.length;
    }

    private void spin() {
        int x = centerX;
        int y = centerY;

        int northX = centerX;
        int southY = centerY;

        int fillLength = 2;

        int nextDigitToInsert = 2;
        while (nextDigitToInsert < max) {
            y++;
            northX--;

            // east
            int ey = y;
            for (int e = 0; e < fillLength; e++) {
                updateGrid(x - e, ey, nextDigitToInsert++);
            }

            // north
            int ny = y - 1;
            for (int n = 0; n < fillLength; n++) {
                updateGrid(northX, ny - n, nextDigitToInsert++);
            }

            // west
            int wy = y - fillLength;
            int wx = northX + 1;
            for (int w = 0; w < fillLength; w++) {
                updateGrid(wx + w, wy, nextDigitToInsert++);
            }

            // south
            int sx = x + 1;
            for(int s = 0; s < fillLength; s++) {
                updateGrid(sx, southY + s, nextDigitToInsert++);
            }

            x++;
            southY--;
            fillLength += 2;
        }
    }

    private int findFirstLagerValue(int input) {
        int x = centerX;
        int y = centerY;

        int northX = centerX;
        int southY = centerY;

        int fillLength = 2;

        int visited = 1;
        int digit;
        while (visited < max) {
            y++;
            northX--;

            // east
            int ey = y;
            for (int e = 0; e < fillLength; e++) {
                visited++;
                digit = getNextDigit(x - e, ey);
                if (digit > input) {
                    return digit;
                }
                addToMatrix(x - e, ey, digit);
            }

            // north
            int ny = y - 1;
            for (int n = 0; n < fillLength; n++) {
                visited++;
                digit = getNextDigit(northX, ny - n);
                if (digit > input) {
                    return digit;
                }
                addToMatrix(northX, ny - n, digit);
            }

            // west
            int wy = y - fillLength;
            int wx = northX + 1;
            for (int w = 0; w < fillLength; w++) {
                visited++;
                digit = getNextDigit(wx + w, wy);
                if (digit > input) {
                    return digit;
                }
                addToMatrix(wx + w, wy, digit);
            }

            // south
            int sx = x + 1;
            for(int s = 0; s < fillLength; s++) {
                visited++;
                digit = getNextDigit(sx, southY + s);
                if (digit > input) {
                    return digit;
                }
                addToMatrix(sx, southY + s, digit);
            }

            x++;
            southY--;
            fillLength += 2;
        }

        return 0;
    }

    public int getNextDigit(int x, int y) {
        int sum = 0;
        for (int y1 = y - 1; y1 <= y + 1; y1++) {
            for(int x1 = x - 1; x1 <= x + 1; x1++) {
                try {
                    if (x1 == x && y1 == y) {
                        continue;
                    }
                    sum += matrix[x1][y1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.printf("non existing element at x: %d, y: %d.\n", x1, y1);
                }
            }
        }
        return sum;
    }

    private void updateGrid(int x, int y, int digit) {
        addToMatrix(x, y, digit);
        addToMap(x, y, digit);
    }

    private void addToMatrix(int x, int y, int digit) {
        matrix[x][y] = digit;
    }

    private void addToMap(int x, int y, int digit) {
        Point p = new Point();
        p.x = x;
        p.y = y;
        mapOfDigits.put(digit, p);
    }

    private void prepareCenter() {
        matrix[centerX][centerY] = 1;
        Point center = new Point();
        center.x = centerX;
        center.y = centerY;

        mapOfDigits.put(1, center);
    }

    public int manhattanDistanceFrom(int fromDigit) {
        prepareCenter();
        spin();
        Point point = mapOfDigits.getOrDefault(fromDigit, new Point());
        return distance(point);
    }

    private int distance(Point point) {
        return Math.abs(centerX - point.x) + Math.abs(centerY - point.y);
    }

    public int nextLargerValue(int input) {
        clearMatrix();
        prepareCenter();
        return findFirstLagerValue(input);
    }

    private void clearMatrix() {
        for (int[] row : matrix) {
            Arrays.fill(row, 0);
        }
    }

    static class Point {
        int x;
        int y;
    }

    public static void main(String[] args) {
        Spiral spiral = new Spiral(270000);
        System.out.printf("Data %d from square is %d steps away.\n", 265149, spiral.manhattanDistanceFrom(265149));
        System.out.printf("Next first lager value of %d is %d", 265149, spiral.nextLargerValue(265149));
    }
}
