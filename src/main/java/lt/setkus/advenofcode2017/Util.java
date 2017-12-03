package lt.setkus.advenofcode2017;

public class Util {

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.printf("%8d", elem);
            }
            System.out.println();
        }
        System.out.println();
    }
}
