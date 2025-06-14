package Matrix;

import static Matrix.Addition.addition;
import static Matrix.Copy.copy;
import static Matrix.Diagonal.diag;
import static Matrix.Identity.eye;
import static Matrix.IsConverged.isConverged;
import static Matrix.IsSquare.isSquare;
import static Matrix.PrintMatrix.printMat;
import static Matrix.Decomposition.qr;
import static Matrix.Multiplication.multiply;
import static Matrix.Scale.scale;
import static Matrix.Subtraction.subtract;
import static Matrix.Transpose.transpose;

/**
 * Utility class for calculating eigenvalues and eigenvectors of a square matrix using the QR algorithm.
 *
 * <p>
 * The main method {@code eig} returns both the eigenvectors and the eigenvalues (in diagonal form) of a matrix.
 * The QR algorithm is used to iteratively decompose the matrix and accumulate the eigenvectors.
 * </p>
 *
 * <p>
 * Usage example:
 * <pre>
 * double[][] matrix = {
 *     {2, 1},
 *     {1, 2}
 * };
 * double[][][] result = Eigen.eig(matrix);
 * double[][] eigenvectors = result[0];
 * double[][] eigenvaluesDiagonal = result[1];
 * </pre>
 * </p>
 *
 * <p>
 * Note: The matrix must be square. If not, a {@link MatrixError} is thrown.
 * </p>
 */
public class Eigen {

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

    public static void main(String[] args) {
        // Test 1: 2x2 identity matrix
        double[][] matrix1 = {
            {1, 0},
            {0, 1}
        };
        runTestWithVectors(matrix1, "Test 1: 2x2 Identity Matrix");

        // Test 2: 2x2 diagonal matrix
        double[][] matrix2 = {
            {3, 0},
            {0, 2}
        };
        runTestWithVectors(matrix2, "Test 2: 2x2 Diagonal Matrix");

        // Test 3: 2x2 symmetric matrix
        double[][] matrix3 = {
            {2, 1},
            {1, 2}
        };
        runTestWithVectors(matrix3, "Test 3: 2x2 Symmetric Matrix");

        // Test 4: 3x3 matrix
        double[][] matrix4 = {
            {6, 2, 1},
            {2, 3, 1},
            {1, 1, 1}
        };
        runTestWithVectors(matrix4, "Test 4: 3x3 Matrix");

        // Test 5: 3x3 matrix with repeated eigenvalues
        double[][] matrix5 = {
            {2, 1, 0},
            {1, 2, 0},
            {0, 0, 3}
        };
        runTestWithVectors(matrix5, "Test 5: 3x3 Matrix with Repeated Eigenvalues");

        double[][] matrix6 = {{1, 2, 3},
                {4, 5, 6}};
        runTestWithVectors(multiply(matrix6, transpose(matrix6)), "Test 6: AAt");

        runTestWithVectors(multiply(transpose(matrix6), matrix6), "Test 7: AtA");

        // Test 8: 2x2 unsymmetric matrix
        double[][] matrix8 = {
                {4, 2},
                {1, 3}
        };
        runTestWithVectors(matrix8, "Test 8: 2x2 Unsymmetric Matrix");

        // Test 9: 3x3 unsymmetric matrix
        double[][] matrix9 = {
                {0, 2, 1},
                {1, 0, 3},
                {4, 1, 0}
        };
        runTestWithVectors(matrix9, "Test 9: 3x3 Unsymmetric Matrix");

        // Test 10: 3x3 unsymmetric matrix with negative entries
        double[][] matrix10 = {
                {2, -1, 0},
                {1, 3, 4},
                {0, -2, 1}
        };
        runTestWithVectors(matrix10, "Test 10: 3x3 Unsymmetric Matrix with Negatives");
    }

    private static void runTestWithVectors(double[][] matrix, String testName) {
        System.out.println(testName);
        System.out.println("Matrix:");
        printMat(matrix);
        double[][][] e = eig(matrix);
        double[][] evals = e[1];
        System.out.println("\nEigenvalues: ");
        printMat(evals);
        System.out.println();
        double[][] evecs = e[0];
        System.out.println("Eigenvectors (columns):");
        printMat(evecs);
        System.out.println("-----------------------------");
    }
}