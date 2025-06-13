package Matrix;

public class IsConverged {
    // To check convergence of matrices
    public static boolean isConverged(double[][] A, double[][] B, double tolerance) {
        int n = A.length;
        int m = A[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Math.abs(A[i][j] - B[i][j]) > tolerance) {
                    return false;  // Difference is too large → Not converged yet
                }
            }
        }
        return true;  // All elements are within tolerance → Converged
    }
}
