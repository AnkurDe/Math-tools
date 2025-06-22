package Matrix;

import static Matrix.Operations.GSO;
import static Matrix.Operations.multiply;
import static Matrix.Operations.transpose;
import static Matrix.Operations.eig;

/**
 * The Decomposition class provides static methods for various matrix decompositions,
 * including Singular Value Decomposition (SVD), QR Decomposition, LU Decomposition,
 * and Polar Decomposition. These decompositions are fundamental in numerical linear algebra
 * and have applications in solving systems of equations, matrix inversion, and more.
 *
 * <p>
 * Each method returns the decomposition in the form of arrays of matrices.
 * </p>
 */
public class Decomposition {

    /**
     * Computes the Singular Value Decomposition (SVD) of a matrix.
     * <p>
     * SVD factorizes a matrix A into three matrices: U, Sigma, and V^T such that:
     * A = U * Sigma * V^T
     * where:
     * <ul>
     *   <li>U is an m x m orthogonal matrix (left singular vectors)</li>
     *   <li>Sigma is an m x n diagonal matrix with non-negative real numbers (singular values)</li>
     *   <li>V^T is the transpose of an n x n orthogonal matrix (right singular vectors)</li>
     * </ul>
     * <b>Algorithm Steps:</b>
     * <ol>
     *   <li>Compute A^T * A and its eigen-decomposition to get V and singular values.</li>
     *   <li>Sort eigenvalues and corresponding eigenvectors in descending order.</li>
     *   <li>Compute singular values as the square roots of eigenvalues.</li>
     *   <li>Compute U as U = A * V * S^(-1) for non-zero singular values.</li>
     *   <li>Complete U to an orthogonal matrix if necessary (using Gram-Schmidt).</li>
     *   <li>Adjust signs for consistency.</li>
     * </ol>
     *
     * @param matrix The input m x n matrix.
     * @return An array of three matrices: {U, Sigma, V^T}.
     */
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

    /**
     * Computes the QR Decomposition of a matrix.
     * <p>
     * QR factorizes a matrix A into Q and R such that:
     * A = Q * R
     * where:
     * <ul>
     *   <li>Q is an orthogonal matrix (columns are orthonormal)</li>
     *   <li>R is an upper triangular matrix</li>
     * </ul>
     * <b>Algorithm Steps:</b>
     * <ol>
     *   <li>Apply Gram-Schmidt Orthogonalization (GSO) to obtain Q.</li>
     *   <li>Compute R as Q^T * A.</li>
     * </ol>
     *
     * @param matrix The input matrix.
     * @return An array of two matrices: {Q, R}.
     */
    public static double[][][] qr(double[][] matrix) {
        double[][] Q = GSO(matrix);
        double[][] R = multiply(transpose(Q), matrix);
        return new double[][][]{Q, R};
    }

    /**
     * Computes the LU Decomposition of a square matrix.
     * <p>
     * LU factorizes a matrix A into L and U such that:
     * A = L * U
     * where:
     * <ul>
     *   <li>L is a lower triangular matrix with unit diagonal</li>
     *   <li>U is an upper triangular matrix</li>
     * </ul>
     * <b>Algorithm Steps:</b>
     * <ol>
     *   <li>Initialize L as the identity matrix and U as a copy of A.</li>
     *   <li>For each column, eliminate entries below the diagonal using Gaussian elimination.</li>
     *   <li>Store multipliers in L and update U accordingly.</li>
     * </ol>
     *
     * @param matrix The input square matrix.
     * @return An array of two matrices: {L, U}.
     */
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

    /**
     * Computes the Polar Decomposition of a matrix.
     * <p>
     * Polar decomposition factorizes a matrix A into:
     * A = U * P
     * where:
     * <ul>
     *   <li>U is a unitary (orthogonal for real matrices) matrix</li>
     *   <li>P is a positive semidefinite Hermitian matrix</li>
     * </ul>
     * <b>Algorithm Steps:</b>
     * <ol>
     *   <li>Compute the SVD: A = W * S * V^T</li>
     *   <li>Set U = W * V^T</li>
     *   <li>Set P = V * S * V^T</li>
     * </ol>
     *
     * @param matrix The input matrix.
     * @return An array of two matrices: {U, P}.
     */
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