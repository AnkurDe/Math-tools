package Matrix;

// Transpose of matrix
// Incomplete
final public class Transpose {
    public static double[][] transpose(double[][] input) {
        double[][] result = new double[input[0].length][input.length];
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < input[0].length; j++)
                result[j][i] = input[i][j];
        return result;
    }
}
