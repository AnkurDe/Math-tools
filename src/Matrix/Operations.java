package Matrix;

import Vector.TestCases.Scale;
import Vector.TestCases.Subtraction;

import static Matrix.Decomposition.lu;
import static Matrix.Decomposition.qr;
import static Vector.Operations.dot;
import static Vector.Operations.normalise;
import static java.lang.Math.min;

public class Operations {
    public static double[][] addition(double[][] A, double[][] B) {

        if (A.length != B.length) {
            throw new MatrixCorruptException("Mismatch in number of rows of matrices");
        }
        if (A[0].length != B[0].length){
            throw new MatrixCorruptException("Mismatch in number of columns of matrices");
        }

        double[][] Sum = new double[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                Sum[i][j] = A[i][j] + B[i][j];
            }
        }
        return Sum;
    }

    public static double[][] aug(double[][] A, double[][] B, char operation) {
        if (Character.toUpperCase(operation) == 'R') {
            return augRow(A, B);
        } else if (Character.toUpperCase(operation) == 'C') {
            return augCol(A, B);
        } else {
            throw new IllegalArgumentException("Invalid operation " + operation);
        }
    }

    // Augment to column side A|B
    public static double[][] augRow(double[][] A, double[][] B) {
        if (A.length != B.length) {
            throw new MatrixError("Number of rows of both matrices must be equal");
        }
        double[][] result = new double[A.length][A[0].length + B[0].length];
        for (int i = 0; i < A.length; i++) {
            System.arraycopy(A[i], 0, result[i], 0, A[0].length);
            System.arraycopy(B[i], 0, result[i], A[0].length, B[0].length);
        }
        return result;
    }

    public static double[][] augCol(double[][] A, double[][] B) {
        if (A[0].length != B[0].length) {
            throw new MatrixError("Number of columns of both matrices must be equal");
        }
        double[][] result = new double[A.length + B.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            System.arraycopy(A[i], 0, result[i], 0, A[0].length);
        }
        for (int i = 0; i < B.length; i++) {
            System.arraycopy(B[i], 0, result[i + A.length], 0, B[0].length);
        }
        return result;
    }

    /**
     * Returns a deep copy of the given matrix.
     * @param mat The matrix to copy.
     * @return A new matrix with the same contents.
     */
    public static double[][] copy(double[][] mat) {
        double[][] out = new double[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            out[i] = mat[i].clone();
        }
        return out;
    }

    // To calculate the determinant of a matrix by LU decomposition
    public static double det(double[][] matrix) {
        if (!isSquare(matrix)){
            throw new MatrixError("Not a square matrix");
        }
        return diag_prod(lu(matrix)[1]);// Perform LU Decomposition
        // and get the diagonal product of Upper triangular matrix from LU Decomposition
    }

    /**
     * Returns a matrix with only the diagonal elements of the input matrix.
     * All off-diagonal elements are set to zero.
     *
     * @param matrix The input 2D array.
     * @return A matrix of the same size with only diagonal elements retained.
     * Example:
     * Input: [[1, 2], [3, 4]]
     * Output: [[1, 0], [0, 4]]
     */
    public static double[][] diag(double[][] matrix) {
        // Create a zero matrix of the same size as input
        double[][] A = zeros(matrix);
        // Copy only the diagonal elements
        for (int i = 0; i < min(matrix.length, matrix[0].length) ; i++) {
            A[i][i] = matrix[i][i];
        }
        return A;
    }

    public static double diag_prod(double[][] matrix) {
        double dp = 1;
        for (int i = 0; i < matrix.length && i < matrix[0].length; i++) {
            dp *= matrix[i][i];
        }
        return dp;
    }

    // Main method: Gram-Schmidt Orthonormalization
    public static double[][] GSO(double[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        double[][] Q = new double[rows][cols];

        for (int j = 0; j < cols; j++) {
            double[] v = new double[rows];
            for (int i = 0; i < rows; i++) v[i] = A[i][j];

            for (int k = 0; k < j; k++) {
                double[] qk = new double[rows];
                for (int i = 0; i < rows; i++) qk[i] = Q[i][k];
                double dotProd = dot(qk, v);
                double[] proj = Vector.Operations.scale(qk,dotProd);
                v = Vector.Operations.subtract(v, proj);
            }

            double[] qj = normalise(v);
            for (int i = 0; i < rows; i++) Q[i][j] = qj[i];
        }

        return Q;
    }

    /**
     * Computes the eigenvectors and eigenvalues of a square matrix using the QR algorithm.
     *
     * @param matrix The input square matrix.
     * @return A 3D array: [0] = eigenvectors (columns), [1] = eigenvalues in diagonal matrix form.
     * @throws MatrixError if the input is not a square matrix.
     */
    public static double[][][] eig(double[][] matrix) {
        return eig(matrix, 10000000);
    }

    /**
     * Computes the eigenvectors and eigenvalues of a square matrix using the QR algorithm,
     * with a specified maximum number of iterations.
     *
     * @param matrix The input square matrix.
     * @param iterations The maximum number of QR iterations to perform.
     * @return A 3D array: [0] = eigenvectors (columns), [1] = eigenvalues in diagonal matrix form.
     * @throws MatrixError if the input is not a square matrix.
     */
    public static double[][][] eig(double[][] matrix, int iterations) {
        // To check if it is a square matrix or not
        if (!isSquare(matrix)) {
            throw new MatrixError("Not a square matrix");
        }

        // Ak -> starts working like A
        double[][] Ak = copy(matrix);
        // Accumulates Q matrices -> eigenvectors
        double[][] QQ = eye(matrix);

        final int n = matrix.length;
        double[][] prevAk;

        for (int i = 0; i < iterations; i++) {
            // Save current Ak to be compared later
            prevAk = copy(Ak);

            double s = Ak[n - 1][n - 1];

            double[][] smult = scale(s, eye(matrix));

            // Perform QR Decomposition
            double[][][] qr = qr(subtract(Ak, smult));
            double[][] Q = qr[0];
            double[][] R = qr[1];

            // Ak -> Ak+1
            Ak = addition(multiply(R, Q), smult);
            // Accumulate eigenvectors with formulae -> QQ = QQ*Q
            QQ = multiply(QQ, Q);

            // In case of early convergence early stopping saves computation
            if (isConverged(Ak, prevAk, 1e-9))
                break;
        }
        // Return [eigenvectors (columns) | eigenvalues (diagonal matrix)]
        return new double[][][]{QQ, diag(Ak)};
    }


    /**
     * Computes the inverse of a square matrix using the Gauss-Jordan elimination method.
     * @param matrix The matrix to invert (will not be modified).
     * @return The inverse matrix.
     * @throws MatrixError if the matrix is not square or not invertible.
     */
    public static double[][] inv(double[][] matrix){
        int n = matrix.length;
        if (n != matrix[0].length){
            throw new MatrixError("Must be square matrix");
        }

        // Using Gauss-Jordan inverse method to invert matrices
        double[][] A = aug(matrix, eye(n), 'r');

        // Gauss-Jordan elimination
        for (int i = 0; i < n; i++) {
            // Partial pivoting
            int maxRow = i;
            double maxVal = Math.abs(A[i][i]);
            for (int k = i + 1; k < n; k++) {
                double absVal = Math.abs(A[k][i]);
                if (absVal > maxVal) {
                    maxVal = absVal;
                    maxRow = k;
                }
            }
            if (maxVal == 0) {
                throw new MatrixError("Matrix is singular or nearly singular");
            }
            // Swap rows if needed
            if (maxRow != i) {
                double[] tmp = A[i];
                A[i] = A[maxRow];
                A[maxRow] = tmp;
            }

            // Normalize pivot row
            double pivot = A[i][i];
            for (int j = 0; j < 2 * n; j++) {
                A[i][j] /= pivot;
            }

            // Eliminate column in other rows
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                double factor = A[j][i];
                for (int k = 0; k < 2 * n; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }

        // Extract the inverse from the right half of A
        double[][] inverse = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], n, inverse[i], 0, n);
        }
        return inverse;
    }

    public static double[][] rightInv(double[][] matrix){
        try{
            return multiply(transpose(matrix), inv(multiply(matrix, transpose(matrix))));
        } catch (MatrixError _){
            throw new MatrixError("Right Inverse does not exist");
        }
    }

    public static double[][] leftInv(double[][] matrix){
        try {
            return multiply(inv(multiply(transpose(matrix), matrix)),transpose(matrix));
        } catch (MatrixError _){
            throw new MatrixError("Left inverse does not exist");
        }
    }

    /**
     * Computes the Moore-Penrose pseudoinverse for full row or full column rank matrices.
     * For full row rank (rows <= cols): returns right inverse.
     * For full column rank (rows >= cols): returns left inverse.
     * For general matrices (including rank-deficient), a full SVD-based pseudoinverse is required.
     * @param matrix The matrix to pseudoinvert.
     * @return The pseudoinverse matrix.
     */
    public static double[][] pinv(double[][] matrix){
        try {
            // Try right inverse first (for full row rank, m <= n)
            return rightInv(matrix);
        } catch (MatrixError _) {
            // If right inverse fails, try left inverse (for full column rank, m >= n)
            return leftInv(matrix);
        }
    }

    public static double[][] eye(double[][] matrix) {
        return eye(matrix.length, matrix[0].length);
    }

    public static double[][] eye(int rows, int cols) {
        double[][] identity = new double[rows][cols];
        for (int i = 0; i < rows && i < cols; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }

    public static double[][] eye(int n) {
        return eye(n, n);
    }

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

    public static boolean isSquare(double[][] input) {
        return input.length == input[0].length;
    }

    public static double[][] multiply(double[][] A, double[][] B) {
        // Correct dimension check: columns of A == rows of B
        if (A[0].length != B.length) {
            throw new DimensionErrorException("The matrices are not compatible for multiplication");
        }
        double[][] result = new double[A.length][B[0].length];
        zeros(result);
        //rows
        for (int i = 0; i < A.length; i++) {
            //columns
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Improved printMat: aligns columns and formats numbers
    public static void printMat(double[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("(empty matrix)");
            return;
        }
        int cols = matrix[0].length;
        int[] colWidths = new int[cols];

        // Calculate max width for each column
        for (double[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                String formatted = String.format("%.4f", row[j]);
                colWidths[j] = Math.max(colWidths[j], formatted.length());
            }
        }

        // Print each row with aligned columns
        for (double[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                String formatted = String.format("%.4f", row[j]);
                System.out.print(" " + String.format("%" + colWidths[j] + "s", formatted));
            }
            System.out.println();
        }
    }

    public static double[][] scale(double scale, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scale * matrix[i][j];
            }
        }
        return matrix.clone();
    }

    public static double[][] subtract(double[][] A, double[][] B) {

        if (A.length != B.length) {
            throw new MatrixCorruptException("Mismatch in number of rows of matrices");
        }
        if (A[0].length != B[0].length){
            throw new MatrixCorruptException("Mismatch in number of columns of matrices");
        }

        double[][] Subtract = new double[A.length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A.length; j++)
                Subtract[i][j] = (A[i][j] - B[i][j]);
        return Subtract;
    }

    public static double[][] transpose(double[][] input) {
        double[][] result = new double[input[0].length][input.length];
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < input[0].length; j++)
                result[j][i] = input[i][j];
        return result;
    }

    // Inputs a matrix and returns a zero matrix of the same size
    public static double[][] zeros(double[][] input) {
        return zeros(input.length, input[0].length);
    }//Tested ok


    // Inputs the number of rows and columns and returns a zero matrix of that size
    public static double[][] zeros(int rows, int cols) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0.0;
            }
        }
        return result;
    }

    // Inputs the size of a square matrix and returns a zero matrix of that size
    public static double[][] zeros(int size) {
        return zeros(size, size);
    }

    /**
     * Computes the Row Reduced Echelon Form (RREF) of the given matrix in-place.
     * @param matrix The matrix to reduce (will be modified).
     * @return The RREF of the matrix.
     */
    public static double[][] rref(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lead = 0;

        for (int r = 0; r < rows; r++) {
            if (lead >= cols) break;
            int i = r;
            while (matrix[i][lead] == 0) {
                i++;
                if (i == rows) {
                    i = r;
                    lead++;
                    if (lead == cols) return matrix;
                }
            }

            // Swap rows i and r
            double[] temp = matrix[i];
            matrix[i] = matrix[r];
            matrix[r] = temp;

            // Normalize the row by making the lead element 1
            double leadValue = matrix[r][lead];
            for (int j = 0; j < cols; j++) {
                matrix[r][j] /= leadValue;
            }

            // Eliminate all other entries in the lead column
            for (int k = 0; k < rows; k++) {
                if (k != r) {
                    double factor = matrix[k][lead];
                    for (int j = 0; j < cols; j++) {
                        matrix[k][j] -= factor * matrix[r][j];
                    }
                }
            }
            lead++;
        }
        return matrix;
    }

}
