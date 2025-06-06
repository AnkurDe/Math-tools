package Matrix;

// For taking diagonal products of elements
final public class DiagonalProduct {
    public static double diag_prod(double[][] matrix) {
        double dp = 1;
        for (int i = 0; i < matrix.length && i < matrix[0].length; i++) {
            dp *= matrix[i][i];
        }
        return dp;
    }
}
