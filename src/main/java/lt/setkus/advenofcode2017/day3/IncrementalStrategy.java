package lt.setkus.advenofcode2017.day3;

public class IncrementalStrategy implements SpinStrategy {

    private int nextDigit = 2;

    @Override
    public int getNextDigit(int x, int y) {
        return nextDigit++;
    }
}
