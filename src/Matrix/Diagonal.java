package Matrix;

import static Matrix.ZeroMatrix.zeros;
import static java.lang.Math.min;

/**
 * Utility class for extracting the diagonal of a matrix.
 */
public class Diagonal {
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

// test cases for diag function

//    public static void main(String[] args) {
//        // Helper to print matrices
//        java.util.function.Consumer<double[][]> printMat = m -> {
//            for (double[] row : m) {
//                for (double v : row) System.out.print(v + " ");
//                System.out.println();
//            }
//        };
//
//        // Test 1: Square matrix
//        double[][] mat1 = {
//            {1, 2},
//            {3, 4}
//        };
//        System.out.println("Test 1: Square matrix");
//        System.out.println("Input:");
//        printMat.accept(mat1);
//        System.out.println("Output:");
//        printMat.accept(diag(mat1));
//        // Expected: [1, 0]
//        //           [0, 4]
//        System.out.println();
//
//        // Test 2: Rectangular matrix (more rows)
//        double[][] mat2 = {
//            {5, 6},
//            {7, 8},
//            {9, 10}
//        };
//        System.out.println("Test 2: Rectangular matrix (more rows)");
//        System.out.println("Input:");
//        printMat.accept(mat2);
//        System.out.println("Output:");
//        printMat.accept(diag(mat2));
//        // Expected: [5, 0]
//        //           [0, 8]
//        //           [0, 0]
//        System.out.println();
//
//        // Test 3: Rectangular matrix (more columns)
//        double[][] mat3 = {
//            {11, 12, 13},
//            {14, 15, 16}
//        };
//        System.out.println("Test 3: Rectangular matrix (more columns)");
//        System.out.println("Input:");
//        printMat.accept(mat3);
//        System.out.println("Output:");
//        printMat.accept(diag(mat3));
//        // Expected: [11, 0, 0]
//        //           [0, 15, 0]
//        System.out.println();
//
//        // Test 4: 1x1 matrix
//        double[][] mat4 = {
//            {42}
//        };
//        System.out.println("Test 4: 1x1 matrix");
//        System.out.println("Input:");
//        printMat.accept(mat4);
//        System.out.println("Output:");
//        printMat.accept(diag(mat4));
//        // Expected: [42]
//        System.out.println();
//
//        // Test 5: Zero matrix
//        double[][] mat5 = {
//            {0, 0},
//            {0, 0}
//        };
//        System.out.println("Test 5: Zero matrix");
//        System.out.println("Input:");
//        printMat.accept(mat5);
//        System.out.println("Output:");
//        printMat.accept(diag(mat5));
//        // Expected: [0, 0]
//        //           [0, 0]
//        System.out.println();
//    }
}
