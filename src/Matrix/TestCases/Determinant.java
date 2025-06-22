package Matrix.TestCases;

import static Matrix.Operations.det;
import static Matrix.Operations.printMat;

final public class Determinant {
    public static void main(String[] args) {
        // Test case 1: 2x2 matrix
        double[][] mat1 = {
                {1, 2},
                {3, 4}
        };
        System.out.println("Matrix 1:");
        printMat(mat1);
        System.out.println("Determinant: " + det(mat1)); // Expected: -2.0

        // Test case 2: 3x3 matrix
        double[][] mat2 = {
                {6, 1, 1},
                {4, -2, 5},
                {2, 8, 7}
        };
        System.out.println("\nMatrix 2:");
        printMat(mat2);
        System.out.println("Determinant: " + det(mat2)); // Expected: -306.0

        // Test case 3: Singular matrix (determinant should be 0)
        double[][] mat3 = {
                {2, 4},
                {1, 2}
        };
        System.out.println("\nMatrix 3:");
        printMat(mat3);
        System.out.println("Determinant: " + det(mat3)); // Expected: 0.0

        // Test case 4: 1x1 matrix
        double[][] mat4 = {
                {5}
        };
        System.out.println("\nMatrix 4:");
        printMat(mat4);
        System.out.println("Determinant: " + det(mat4)); // Expected: 5.0
    }
}