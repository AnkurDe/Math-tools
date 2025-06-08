package Matrix;

import static Matrix.Augment.aug;
import static Matrix.Identity.eye;
import static Matrix.PrintMatrix.printMat;
import static Vector.Scale.scale;
import static Vector.Subtraction.subtract;

final public class Inverse
{

    public static double[][] inv(double[][] matrix){
        if (matrix.length!=matrix[0].length){
            throw new MatrixError("Must be square matrix");
        }

        int length = matrix.length;
        // Using Gauss-Jordan inverse method to invert matrices
        double[][] A = aug(matrix,eye(length),'r');

        System.out.println("Original matrix");
        printMat(A);

        // For making the left-hand size in zeros
        for (int i = 0; i < length; i++) { // Pivot for inverse of matrix
            double pivot = A[i][i];
            if (pivot == 0){
                throw new MatrixError("Singular matrix");
            }
            A[i] = scale(A[i], 1.0/pivot);// (Vector/pivotal element)
            for (int j = i+1; j < length; j++) { //Operation on the rows
                double factor = A[i][j];
                double[] temp = scale(A[i], factor);
                A[j] = subtract(A[j], temp);
            }
        }
        System.out.println("After Left hand operation");
        printMat(A);


        // For making the right-hand side in zeros
        for (int i = length-1; i >= 0; i--) { // Pivot for inverse of matrix
            A[i] = scale(A[i], 1.0/A[i][i]);// (Vector/pivotal element)
            for (int j = i - 1; j > 0; j--) { //Operation on the rows
                double[] temp = scale(A[j], 1.0/A[j][i]);
                A[j] = subtract(temp,A[i]);
            }
        }
        System.out.println("After Right hand operation");
        printMat(A);

        // Final traversal to make diagonal left elements as 1
        for (int i = 0; i < length; i++) {
            A[i] = scale(A[i], 1.0/A[i][i]);
        }
        System.out.println("\n\n");
        return A;
    }

//    public static double[][] inv(double[][] matrix) {
//        int n = matrix.length;
//        if (n != matrix[0].length) {
//            throw new MatrixError("Must be square matrix");
//        }
//
//        // Build augmented matrix [A | I]
//        double[][] A = new double[n][2 * n];
//        for (int i = 0; i < n; i++) {
//            // copy A
//            System.arraycopy(matrix[i], 0, A[i], 0, n);
//            // set identity
//            A[i][n + i] = 1.0;
//        }
//
//        // Gauss-Jordan elimination
//        for (int i = 0; i < n; i++) {
//            // --- 1) Partial pivoting: find the row with max abs in col i ---
//            int maxRow = i;
//            double maxVal = Math.abs(A[i][i]);
//            for (int k = i + 1; k < n; k++) {
//                double absVal = Math.abs(A[k][i]);
//                if (absVal > maxVal) {
//                    maxVal = absVal;
//                    maxRow = k;
//                }
//            }
//            if (maxVal == 0) {
//                throw new MatrixError("Matrix is singular or nearly singular");
//            }
//            // swap to put best pivot on A[i]
//            if (maxRow != i) {
//                double[] tmp = A[i];
//                A[i] = A[maxRow];
//                A[maxRow] = tmp;
//            }
//
//            // --- 2) Normalize pivot row i so A[i][i] becomes 1 ---
//            double pivot = A[i][i];
//            A[i] = scale(A[i], 1.0 / pivot);
//
//            // --- 3) Eliminate this column in all other rows ---
//            for (int j = 0; j < n; j++) {
//                if (j == i) continue;
//                double factor = A[j][i];           // amount to eliminate
//                double[] scaledPivot = scale(A[i], factor);
//                A[j] = subtract(A[j], scaledPivot);
//            }
//        }
//        // Extract the inverse from the right half of A
//        double[][] inverse = new double[n][n];
//        for (int i = 0; i < n; i++) {
//            System.arraycopy(A[i], n, inverse[i], 0, n);
//        }
//        return inverse;
//    }

    public static void main(String[] args) {
        // Full rank matrix
        printMat(inv(new double[][]{
                {2,3},
                {4,5},
        }));

        // Not full rank matrix
        printMat(inv(new double[][]{
                {2,3,1},
                {4,5,1},
                {1,1,0}
        }));

        // Full rank matrix
        printMat(inv(new double[][]{
                {2,3,1},
                {4,5,1},
                {1,1,0}
        }));
    }
}