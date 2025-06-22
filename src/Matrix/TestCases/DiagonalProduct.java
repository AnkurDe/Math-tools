package Matrix.TestCases;

import static Matrix.Operations.diag_prod;
import static Matrix.Operations.printMat;

public final class DiagonalProduct {
    public static void main(String[] args) {
        // Test case 1: 2x2 matrix
        double[][] mat1 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Matrix 1:");
        printMat(mat1);
        System.out.println("Diagonal product: " + diag_prod(mat1)); // Expected: 1*4 = 4

        // Test case 2: 3x3 matrix
        double[][] mat2 = {
            {2, 0, 1},
            {0, 3, 0},
            {4, 0, 5}
        };
        System.out.println("\nMatrix 2:");
        printMat(mat2);
        System.out.println("Diagonal product: " + diag_prod(mat2)); // Expected: 2*3*5 = 30

        // Test case 3: Matrix with zero on diagonal
        double[][] mat3 = {
            {0, 1},
            {2, 3}
        };
        System.out.println("\nMatrix 3:");
        printMat(mat3);
        System.out.println("Diagonal product: " + diag_prod(mat3)); // Expected: 0*3 = 0

        // Test case 4: Non-square matrix (2x3)
        double[][] mat4 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("\nMatrix 4:");
        printMat(mat4);
        System.out.println("Diagonal product: " + diag_prod(mat4)); // Expected: 1*5 = 5

        // Test case 5: 1x1 matrix
        double[][] mat5 = {
            {7}
        };
        System.out.println("\nMatrix 5:");
        printMat(mat5);
        System.out.println("Diagonal product: " + diag_prod(mat5)); // Expected: 7
    }
}
