package Matrix.TestCases;

// For taking row reduced the echelon form


import static Matrix.Operations.*;

/**
 * RREF provides a static method to compute the Row Reduced Echelon Form (RREF) of a matrix.
 * The main method demonstrates usage with several test cases.
 * Algorithm:
 * - For each row, find the leftmost nonzero column (the "lead").
 * - Swap the current row with a row below if needed to get a nonzero lead.
 * - Normalize the row so the lead is 1.
 * - Eliminate all other entries in the lead column by subtracting suitable multiples of the current row from the others.
 * - Repeat for the next row and next column.
 * Helper methods:
 * - printMatrix: Nicely prints a matrix to the console.
 * - copy: Deep-copies a matrix to avoid mutating test data.
 */
final public class RREF {

    /**
     * Demonstrates the rref function with several test cases.
     * Each test prints the input matrix, the RREF result, and the expected output as a comment.
     */
    public static void main(String[] args) {
        // Test case 1: 2x2 identity
        double[][] mat1 = {
            {1, 0},
            {0, 1}
        };
        System.out.println("Test 1: 2x2 Identity");
        printMat(rref(copy(mat1)));
        // Expected:
        // 1.00 0.00
        // 0.00 1.00

        // Test case 2: 2x2 invertible
        double[][] mat2 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("\nTest 2: 2x2 invertible");
        printMat(rref(copy(mat2)));
        // Expected:
        // 1.00 0.00
        // 0.00 1.00

        // Test case 3: 3x3 with zero row
        double[][] mat3 = {
            {1, 2, 3},
            {4, 5, 6},
            {0, 0, 0}
        };
        System.out.println("\nTest 3: 3x3 with zero row");
        printMat(rref(copy(mat3)));
        // Expected:
        // 1.00 0.00 -1.00
        // 0.00 1.00  2.00
        // 0.00 0.00  0.00

        // Test case 4: 3x3 rank 2
        double[][] mat4 = {
            {1, 2, 3},
            {2, 4, 6},
            {1, 1, 1}
        };
        System.out.println("\nTest 4: 3x3 rank 2");
        printMat(rref(copy(mat4)));
        // Expected:
        // 1.00 0.00 1.00
        // 0.00 1.00 1.00
        // 0.00 0.00 0.00

        // Test case 5: 2x3 underdetermined
        double[][] mat5 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("\nTest 5: 2x3 underdetermined");
        printMat(rref(copy(mat5)));
        // Expected:
        // 1.00 0.00 -1.00
        // 0.00 1.00  2.00
    }

}