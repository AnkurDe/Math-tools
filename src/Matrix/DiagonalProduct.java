package Matrix;

// For taking diagonal products of elements
final public class DiagonalProduct {
    public static double diag_prod(double[][] Matrix) {
        double dp = 1;
        for (int i = 0; i < Matrix.length; i++) {
            dp *= Matrix[i][i];
        }
        return dp;
    }
}
