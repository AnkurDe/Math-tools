package Matrix;


import static Matrix.Operations.*;
import static Matrix.Operations.GSO;
import static Matrix.Operations.multiply;
import static Matrix.Operations.transpose;

public class Decomposition {
    public static double[][][] svd(double[][] A) {
        // SVD: A = U * S * V^T
        int m = A.length;      // number of rows
        int n = A[0].length;   // number of columns
        int minDim = Math.min(m, n);

        // 1. Compute A^T * A and A * A^T
        double[][] At = transpose(A);
        double[][] AtA = multiply(At, A);  // n x n matrix

        // 2. Eigen-decompose A^T*A for V and eigenvalues
        double[][][] eigV = eig(AtA);
        double[][] V = eigV[0];           // n x n eigenvectors
        double[][] eigenvaluesV = eigV[1]; // n x n diagonal matrix of eigenvalues

        // 3. Extract and sort eigenvalues in descending order
        double[] eigenvals = new double[n];
        for (int i = 0; i < n; i++) {
            eigenvals[i] = Math.max(eigenvaluesV[i][i], 0); // ensure non-negative
        }

        // Create an indices array for sorting
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices by eigenvalues in descending order
        java.util.Arrays.sort(indices, (i, j) -> Double.compare(eigenvals[j], eigenvals[i]));

        // 4. Compute singular values and reorder V
        double[] singularValues = new double[minDim];
        double[][] V_sorted = new double[n][n];

        for (int i = 0; i < n; i++) {
            int originalIndex = indices[i];
            if (i < minDim) {
                singularValues[i] = Math.sqrt(eigenvals[originalIndex]);
            }
            // Copy the eigenvector column
            for (int j = 0; j < n; j++) {
                V_sorted[j][i] = V[j][originalIndex];
            }
        }

        // 5. Compute U using U = A * V * S^(-1) for non-zero singular values
        double[][] U = new double[m][m];

        // First compute the first minDim columns of U
        for (int i = 0; i < minDim; i++) {
            if (singularValues[i] > 1e-10) { // avoid division by very small numbers
                // u_i = (1/sigma_i) * A * v_i
                double[] v_i = new double[n];
                for (int j = 0; j < n; j++) {
                    v_i[j] = V_sorted[j][i];
                }

                // Compute A * v_i
                double[] Av_i = new double[m];
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        Av_i[j] += A[j][k] * v_i[k];
                    }
                }

                // u_i = (1/sigma_i) * A * v_i
                for (int j = 0; j < m; j++) {
                    U[j][i] = Av_i[j] / singularValues[i];
                }
            } else {
                // For zero singular values, set corresponding U column to zero
                for (int j = 0; j < m; j++) {
                    U[j][i] = 0.0;
                }
            }
        }

        // If m > minDim, we need to complete U to make it orthogonal
        // This is a simplified approach - in practice, you'd use Gram-Schmidt
        // to orthogonalize the remaining columns
        if (m > minDim) {
            // For the remaining columns, use Gram-Schmidt or leave as identity
            for (int i = minDim; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    U[j][i] = (i == j) ? 1.0 : 0.0;
                }
            }
            // Apply Gram-Schmidt to orthogonalize remaining columns
            U = GSO(U);
        }

        // 6. Ensure consistent signs (make first non-zero element of each column positive)
        for (int i = 0; i < minDim; i++) {
            // Find first non-zero element in U column
            int firstNonZero = -1;
            for (int j = 0; j < m; j++) {
                if (Math.abs(U[j][i]) > 1e-10) {
                    firstNonZero = j;
                    break;
                }
            }

            if (firstNonZero >= 0 && U[firstNonZero][i] < 0) {
                // Flip signs of both U column and V column
                for (int j = 0; j < m; j++) {
                    U[j][i] = -U[j][i];
                }
                for (int j = 0; j < n; j++) {
                    V_sorted[j][i] = -V_sorted[j][i];
                }
            }
        }

        // 7. Build Sigma matrix (m x n)
        double[][] Sigma = new double[m][n];
        for (int i = 0; i < minDim; i++) {
            Sigma[i][i] = singularValues[i];
        }

        // 8. Return U, Sigma, V^T
        return new double[][][]{U, Sigma, transpose(V_sorted)};
    }

    public static double[][][] qr(double[][] matrix) {
        double[][] Q = GSO(matrix);
        double[][] R = multiply(transpose(Q), matrix);
        return new double[][][]{Q, R};
    }

    public static double[][][] lu(double[][] A) {
        int n = A.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    L[i][j] = 1.0;
                } else {
                    L[i][j] = 0.0;
                }
                U[i][j] = A[i][j];
            }
        }

        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                L[i][k] = U[i][k] / U[k][k];
                for (int j = k; j < n; j++) {
                    U[i][j] -= L[i][k] * U[k][j];
                }
            }
        }

        return new double[][][]{L, U};
    }

/**
 * Test cases for the svd function.
 */
//    public static void main(String[] args) {
//        double[][][] testMatrices = {
//            {
//                {1, 0},
//                {0, 1}
//            },
//            {
//                {3, 1},
//                {1, 3}
//            },
//            {
//                {1, 2, 3},
//                {4, 5, 6}
//            },
//            {
//                {2, 4},
//                {1, 3},
//                {0, 0}
//            }
//        };
//        String[] testNames = {
//            "Test 1: 2x2 Identity Matrix",
//            "Test 2: 2x2 Symmetric Matrix",
//            "Test 3: 2x3 Rectangular Matrix",
//            "Test 4: 3x2 Rectangular Matrix with Zero Row"
//        };
//
//        for (int i = 0; i < testMatrices.length; i++) {
//            System.out.println(testNames[i]);
//            double[][] A = testMatrices[i];
//            System.out.println("Input Matrix A:");
//            printMat(A);
//
//            double[][][] svdResult = svd(A);
//            double[][] U = svdResult[0];
//            double[][] S = svdResult[1];
//            double[][] Vt = svdResult[2];
//
//            System.out.println("U:");
//            printMat(U);
//            System.out.println("Sigma:");
//            printMat(S);
//            System.out.println("V^T:");
//            printMat(Vt);
//
//            // Reconstruct A = U * S * V^T
//            double[][] US = multiply(U, S);
//            double[][] USVt = multiply(US, Vt);
//            System.out.println("Reconstructed A (U * Sigma * V^T):");
//            printMat(USVt);
//
//            System.out.println("=====================================");
//        }
//    }
}