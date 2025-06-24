package Matrix.TestCases;

import Matrix.Operations;

import static Matrix.Operations.printMat;
import static Matrix.Operations.rref;

/**
 * Test cases for the RREF (Row Reduced Echelon Form) function.
 * Demonstrates RREF on different types of matrices.
 */
public class RREF {
    public static void main(String[] args) {
        // Test 1: 2x2 identity matrix
        double[][] mat1 = {
            {1, 0},
            {0, 1}
        };
        System.out.println("Test 1: 2x2 Identity Matrix");
        printMat(rref(Operations.copy(mat1)));
        System.out.println();

        // Test 2: 3x3 matrix with a row of zeros
        double[][] mat2 = {
            {1, 2, 3},
            {0, 0, 0},
            {4, 5, 6}
        };
        System.out.println("Test 2: 3x3 Matrix with Zero Row");
        printMat(rref(Operations.copy(mat2)));
        System.out.println();

        // Test 3: 3x4 augmented matrix (system of equations)
        double[][] mat3 = {
            {1, 2, -1, 8},
            {2, 3, -1, 13},
            {-1, 0, 2, 3}
        };
        System.out.println("Test 3: 3x4 Augmented Matrix");
        printMat(rref(Operations.copy(mat3)));
        System.out.println();

        // Test 4: 4x4 singular matrix
        double[][] mat4 = {
            {2, 4, 1, 3},
            {0, 0, 0, 0},
            {1, 2, 0.5, 1.5},
            {3, 6, 1.5, 4.5}
        };
        System.out.println("Test 4: 4x4 Singular Matrix");
        printMat(rref(Operations.copy(mat4)));
        System.out.println();

        // Test 5: 2x3 matrix (more columns than rows)
        double[][] mat5 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("Test 5: 2x3 Matrix");
        printMat(rref(Operations.copy(mat5)));
        System.out.println();
    }
}
