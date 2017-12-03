package lt.setkus.advenofcode2017.day3;

public class AdjencatSumStrategy implements SpinStrategy {

    private final int[][] matrix;

    public AdjencatSumStrategy(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public int getNextDigit(int x, int y) {
        int sum = 0;
//        for (int y1 = y - 1; y1 < y + 1; y1++) {
//            for(int x1 = x - 1; x1 < x + 1; x1++) {
//                try {
//                    int[] row = matrix[y1];
//                    for (int r = 0; r < row.length; r++) {
//                        sum += row[r];
//                    }
//                } catch (ArrayIndexOutOfBoundsException e) {
//
//                }
//            }
//        }
        return sum;
    }
}
