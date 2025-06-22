package Matrix.TestCases;

import static Matrix.Operations.diag;
import static Matrix.Operations.printMat;

/**
 * Utility class for extracting the diagonal of a matrix.
 */
public class Diagonal {
 // test cases for diag function
    public static void main(String[] args) {

        // Test 1: Square matrix
        double[][] mat1 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Test 1: Square matrix");
        System.out.println("Input:");
        printMat(mat1);
        System.out.println("Output:");
        printMat(diag(mat1));
        // Expected: [1, 0]
        //           [0, 4]
        System.out.println();

        // Test 2: Rectangular matrix (more rows)
        double[][] mat2 = {
            {5, 6},
            {7, 8},
            {9, 10}
        };
        System.out.println("Test 2: Rectangular matrix (more rows)");
        System.out.println("Input:");
        printMat(mat2);
        System.out.println("Output:");
        printMat(diag(mat2));
        // Expected: [5, 0]
        //           [0, 8]
        //           [0, 0]
        System.out.println();

        // Test 3: Rectangular matrix (more columns)
        double[][] mat3 = {
            {11, 12, 13},
            {14, 15, 16}
        };
        System.out.println("Test 3: Rectangular matrix (more columns)");
        System.out.println("Input:");
        printMat(mat3);
        System.out.println("Output:");
        printMat(diag(mat3));
        // Expected: [11, 0, 0]
        //           [0, 15, 0]
        System.out.println();

        // Test 4: 1x1 matrix
        double[][] mat4 = {
            {42}
        };
        System.out.println("Test 4: 1x1 matrix");
        System.out.println("Input:");
        printMat(mat4);
        System.out.println("Output:");
        printMat(diag(mat4));
        // Expected: [42]
        System.out.println();

        // Test 5: Zero matrix
        double[][] mat5 = {
            {0, 0},
            {0, 0}
        };
        System.out.println("Test 5: Zero matrix");
        System.out.println("Input:");
        printMat(mat5);
        System.out.println("Output:");
        printMat(diag(mat5));
        // Expected: [0, 0]
        //           [0, 0]
        System.out.println();
    }
}
