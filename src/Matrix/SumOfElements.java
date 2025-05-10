package Matrix;

import java.util.Arrays;

// To take sum of all the elements in the matrix
final public class SumOfElements {
    public static double sum(double[][] input) {
        double sum = 0;
        for (double[] doubles : input) {
            sum += Arrays.stream(doubles, 0, input[0].length).sum();
        }
        return sum;
    }
}
