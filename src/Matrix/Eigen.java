package Matrix;

import static Matrix.PrintMatrix.printMat;
import static Matrix.Decomposition.qr;
import static Matrix.Multiplication.multiply;

// To calculate eigen values and eigen vectors of a matrix
public class Eigen {
    public static double[][] eigen(double[][] matrix) {
        return null;
    }
    public static double[] eigenvalues(double[][] matrix){
        if (matrix.length != matrix[0].length) {
            throw new MatrixError("Not a Square matrix");
        }
        // QR method of finding eigenvalues
        int n = matrix.length;
        double[][] A = new double[n][n];
        // Copy input matrix to avoid mutation
        for (int i = 0; i < n; i++)
            System.arraycopy(matrix[i], 0, A[i], 0, n);

        int maxIter = 1000;
        double tol = 1e-10;
        for (int iter = 0; iter < maxIter; iter++) {
            double[][][] qrResult = qr(A);
            double[][] Q = qrResult[0];
            double[][] R = qrResult[1];
            A = multiply(R, Q);

            // Check for convergence (off-diagonal elements are small)
            double offDiag = 0.0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (i != j) offDiag += Math.abs(A[i][j]);
            if (offDiag < tol) break;
        }
        double[] eigenvalues = new double[n];
        for (int i = 0; i < n; i++)
            eigenvalues[i] = A[i][i];
        return eigenvalues;
    }

    public static void main(String[] args) {
        // Test 1: 2x2 identity matrix
        double[][] matrix1 = {
            {1, 0},
            {0, 1}
        };
        runTest(matrix1, "Test 1: 2x2 Identity Matrix");

        // Test 2: 2x2 diagonal matrix
        double[][] matrix2 = {
            {3, 0},
            {0, 2}
        };
        runTest(matrix2, "Test 2: 2x2 Diagonal Matrix");

        // Test 3: 2x2 symmetric matrix
        double[][] matrix3 = {
            {2, 1},
            {1, 2}
        };
        runTest(matrix3, "Test 3: 2x2 Symmetric Matrix");

        // Test 4: 3x3 matrix
        double[][] matrix4 = {
            {6, 2, 1},
            {2, 3, 1},
            {1, 1, 1}
        };
        runTest(matrix4, "Test 4: 3x3 Matrix");

        // Test 5: 3x3 matrix with repeated eigenvalues
        double[][] matrix5 = {
            {2, 1, 0},
            {1, 2, 0},
            {0, 0, 3}
        };
        runTest(matrix5, "Test 5: 3x3 Matrix with Repeated Eigenvalues");
    }

    private static void runTest(double[][] matrix, String testName) {
        System.out.println(testName);
        System.out.println("Matrix:");
        printMat(matrix);
        double[] evals = eigenvalues(matrix);
        System.out.print("Eigenvalues: ");
        for (double v : evals) {
            System.out.printf("%.6f ", v);
        }
        System.out.println("\n-----------------------------");
    }
}