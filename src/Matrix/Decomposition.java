package Matrix;

import static Matrix.Operations.GSO;
import static Matrix.Operations.multiply;
import static Matrix.Operations.transpose;
import static Matrix.Operations.eig;

public class Decomposition {
    public static double[][][] svd(double[][] matrix) {
        // SVD: matrix = U * S * V^T
        int m = matrix.length;      // number of rows
        int n = matrix[0].length;   // number of columns
        int minDim = Math.min(m, n);

        // 1. Compute matrix^T * matrix and matrix * matrix^T
        double[][] At = transpose(matrix);
        double[][] AtA = multiply(At, matrix);  // n x n matrix

        // 2. Eigen-decompose matrix^T*matrix for V and eigenvalues
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

        // 5. Compute U using U = matrix * V * S^(-1) for non-zero singular values
        double[][] U = new double[m][m];

        // First compute the first minDim columns of U
        for (int i = 0; i < minDim; i++) {
            if (singularValues[i] > 1e-10) { // avoid division by very small numbers
                // u_i = (1/sigma_i) * matrix * v_i
                double[] v_i = new double[n];
                for (int j = 0; j < n; j++) {
                    v_i[j] = V_sorted[j][i];
                }

                // Compute matrix * v_i
                double[] Av_i = new double[m];
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        Av_i[j] += matrix[j][k] * v_i[k];
                    }
                }

                // u_i = (1/sigma_i) * matrix * v_i
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

        double[][] Sigma = new double[m][n];
        for (int i = 0; i < minDim; i++) {
            Sigma[i][i] = singularValues[i];
        }

        return new double[][][]{U, Sigma, transpose(V_sorted)};
    }

    public static double[][][] qr(double[][] matrix) {
        double[][] Q = GSO(matrix);
        double[][] R = multiply(transpose(Q), matrix);
        return new double[][][]{Q, R};
    }

    public static double[][][] lu(double[][] matrix) {
        int n = matrix.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    L[i][j] = 1.0;
                } else {
                    L[i][j] = 0.0;
                }
                U[i][j] = matrix[i][j];
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

    public static double[][][] polar(double[][] matrix) {
        // A = UP where U is unitary/orthogonal and P is positive semidefinite
        // Using SVD: A = WSV^T
        // Then U = WV^T and P = VSV^T
        double[][][] svd = svd(matrix);
        double[][] W = svd[0];
        double[][] S = svd[1];
        double[][] Vt = svd[2];
        double[][] V = transpose(Vt);

        // Calculate U = WV^T
        double[][] U = multiply(W, Vt);

        // Calculate P = VSV^T
        double[][] P = multiply(multiply(V, S), Vt);

        return new double[][][] {U, P};
    }
}