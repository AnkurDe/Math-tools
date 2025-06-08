package Matrix;

import static Matrix.Augment.aug;
import static Matrix.Identity.eye;
import static Matrix.Multiplication.multiply;
import static Matrix.Transpose.transpose;
//import static Matrix.PrintMatrix.printMat;

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

    public static double[][] pinv(double[][] matrix){
        return null;
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
//
//        // Test Right Inverse (rightInv) for a 2x3 full row rank matrix
//        double[][] A1 = {
//            {1, 2, 3},
//            {4, 5, 6}
//        };
//        System.out.println("Right Inverse (rightInv) of 2x3 matrix:");
//        printMat(rightInv(A1));
//        // Expected: A1 * rightInv(A1) ≈ I (2x2 identity)
//        System.out.println("A1 * rightInv(A1):");
//        printMat(multiply(A1, rightInv(A1)));
//
//        // Test Left Inverse (leftInv) for a 3x2 full column rank matrix
//        double[][] A2 = {
//            {1, 4},
//            {2, 5},
//            {3, 6}
//        };
//        System.out.println("Left Inverse (leftInv) of 3x2 matrix:");
//        printMat(leftInv(A2));
//        // Expected: leftInv(A2) * A2 ≈ I (2x2 identity)
//        System.out.println("leftInv(A2) * A2:");
//        printMat(multiply(leftInv(A2), A2));
//
//        // Test: rightInv(A1) * A1 ≈ I (3x3 identity, but not expected to be identity for non-square)
//        System.out.println("rightInv(A1) * A1:");
//        printMat(multiply(rightInv(A1), A1));
//
//        // Test: A2 * leftInv(A2) ≈ I (3x3 identity, but not expected to be identity for non-square)
//        System.out.println("A2 * leftInv(A2):");
//        printMat(multiply(A2, leftInv(A2)));
//
//        // Test: Inverse does not exist (singular square matrix)
//        try {
//            System.out.println("Inverse of singular 2x2 matrix:");
//            printMat(inv(new double[][]{
//                {1, 2},
//                {2, 4}
//            }));
//        } catch (MatrixError e) {
//            System.out.println("Inverse does not exist (singular matrix)");
//        }
//
//        // Test: Right inverse does not exist (not full row rank)
//        double[][] B1 = {
//            {1, 2, 3},
//            {2, 4, 6}
//        };
//        try {
//            System.out.println("Right Inverse (rightInv) does not exist for:");
//            printMat(rightInv(B1));
//        } catch (MatrixError e) {
//            System.out.println("Right Inverse does not exist (not full row rank)");
//        }
//
//        // Test: Left inverse does not exist (not full column rank)
//        double[][] B2 = {
//            {1, 2},
//            {2, 4},
//            {3, 6}
//        };
//        try {
//            System.out.println("Left Inverse (leftInv) does not exist for:");
//            printMat(leftInv(B2));
//        } catch (MatrixError e) {
//            System.out.println("Left Inverse does not exist (not full column rank)");
//        }
//    }
}