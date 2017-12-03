package lt.setkus.advenofcode2017.day3;

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

    private void spin(SpinStrategy spinStrategy) {
        int x = centerX;
        int y = centerY;

        int nx = centerX;
        int sy = centerY;

        int fillLength = 2;

        int visited = 1;
        while (visited < max) {
            y++;
            nx--;

            // east
            int ey = y;
            for (int e = 0; e < fillLength; e++) {
                visited++;
                updateGrid(x - e, ey, spinStrategy.getNextDigit(x - e, ey));
            }

            // north
            int ny = y - 1;
            for (int n = 0; n < fillLength; n++) {
                visited++;
                updateGrid(nx, ny, spinStrategy.getNextDigit(nx, ny));
            }

            // west
            int wy = y - fillLength;
            int wx = nx + 1;
            for (int w = 0; w < fillLength; w++) {
                visited++;
                updateGrid(wx + w, wy, spinStrategy.getNextDigit(wx + w, wy));
            }

            // south
            int sx = x + 1;
            for(int s = 0; s < fillLength; s++) {
                visited++;
                updateGrid(sx, sy + s, spinStrategy.getNextDigit(sx, sy + s));
            }

            x++;
            sy--;
            fillLength += 2;
        }
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
        spin(new IncrementalStrategy());

        Point point = mapOfDigits.getOrDefault(fromDigit, new Point());
        return distance(point);
    }

    private int distance(Point point) {
        return Math.abs(centerX - point.x) + Math.abs(centerY - point.y);
    }

    public int nextLargerValue(int input) {
        return 0;
    }

    static class Point {
        int x;
        int y;
    }

    public static void main(String[] args) {
        Spiral spiral = new Spiral(270000);
        System.out.printf("Data %d from square is %d steps away.", 265149, spiral.manhattanDistanceFrom(265149));
    }
}
