package Matrix.TestCases;

import static Matrix.Decomposition.lu;
import static Matrix.Operations.multiply;
import static Matrix.Operations.printMat;

public class LU {
    public static void main(String[] args) {
        // Test 1: 3x3 matrix
        double[][] A1 = {
            {2, 3, 1},
            {4, 7, 7},
            {6, 18, 22}
        };
        System.out.println("Test 1: 3x3 matrix");
        System.out.println("A1:");
        printMat(A1);
        double[][][] lu1 = lu(A1);
        System.out.println("L:");
        printMat(lu1[0]);
        System.out.println("U:");
        printMat(lu1[1]);
        System.out.println("L * U:");
        printMat(multiply(lu1[0], lu1[1]));
        // Expected: L*U should reconstruct A1

        // Test 2: 2x2 matrix
        double[][] A2 = {
            {4, 3},
            {6, 3}
        };
        System.out.println("\nTest 2: 2x2 matrix");
        System.out.println("A2:");
        printMat(A2);
        double[][][] lu2 = lu(A2);
        System.out.println("L:");
        printMat(lu2[0]);
        System.out.println("U:");
        printMat(lu2[1]);
        System.out.println("L * U:");
        printMat(multiply(lu2[0], lu2[1]));
        // Expected: L*U should reconstruct A2

        // Test 3: Identity matrix
        double[][] A3 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        System.out.println("\nTest 3: 3x3 Identity matrix");
        System.out.println("A3:");
        printMat(A3);
        double[][][] lu3 = lu(A3);
        System.out.println("L:");
        printMat(lu3[0]);
        System.out.println("U:");
        printMat(lu3[1]);
        System.out.println("L * U:");
        printMat(multiply(lu3[0], lu3[1]));
        // Expected: L and U should both be identity, L*U = A3

        // Test 4: Singular matrix (should still decompose, but U will have zeros on diagonal)
        double[][] A4 = {
            {2, 4},
            {1, 2}
        };
        System.out.println("\nTest 4: 2x2 Singular matrix");
        System.out.println("A4:");
        printMat(A4);
        double[][][] lu4 = lu(A4);
        System.out.println("L:");
        printMat(lu4[0]);
        System.out.println("U:");
        printMat(lu4[1]);
        System.out.println("L * U:");
        printMat(multiply(lu4[0], lu4[1]));
        // Expected: L*U should reconstruct A4 (the second row of U will be zeros)
    }
}
