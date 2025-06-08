package Matrix;

import static Matrix.Augment.aug;
import static Matrix.Identity.eye;
import static Matrix.PrintMatrix.printMat;

final public class Inverse
{
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

//    public static void main(String[] args) {
//        // Full rank matrix
//        System.out.println("Inverse of 2x2 matrix:");
//        printMat(inv(new double[][]{
//                {2,3},
//                {4,5},
//        }));
//
//        // Not full rank matrix (should throw)
//        try {
//            System.out.println("Inverse of singular 3x3 matrix:");
//            printMat(inv(new double[][]{
//                    {2, 3, 1},
//                    {4, 6, 2},
//                    {1, 1.5, 0.5}
//            }));
//        } catch (MatrixError e) {
//            System.out.println("Not invertible");
//        }
//
//        // Full rank 3x3 matrix
//        System.out.println("Inverse of 3x3 matrix:");
//        printMat(inv(new double[][]{
//                {2,3,1},
//                {4,5,1},
//                {1,1,2}
//        }));
//    }
}
