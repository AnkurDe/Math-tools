package Matrix.TestCases;

import static Matrix.Operations.multiply;
import static Matrix.Operations.printMat;

// To perform matrix multiplication
final public class Multiplication{
    //    // Test cases for multiply
    public static void main(String[] args) {
        // Test 1: 2x2 * 2x2
        double[][] A1 = {
            {1, 2},
            {3, 4}
        };
        double[][] B1 = {
            {5, 6},
            {7, 8}
        };
        System.out.println("Test 1: 2x2 * 2x2");
        System.out.println("A1:");
        printMat(A1);
        System.out.println("B1:");
        printMat(B1);
        double[][] result1 = multiply(A1, B1);
        System.out.println("A1 * B1:");
        printMat(result1);
        // Expected:
        // 19.0 22.0
        // 43.0 50.0

        // Test 2: 2x3 * 3x2
        double[][] A2 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        double[][] B2 = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        System.out.println("\nTest 2: 2x3 * 3x2");
        System.out.println("A2:");
        printMat(A2);
        System.out.println("B2:");
        printMat(B2);
        double[][] result2 = multiply(A2, B2);
        System.out.println("A2 * B2:");
        printMat(result2);
        // Expected:
        // 58.0 64.0
        // 139.0 154.0

        // Test 3: Identity matrix
        double[][] I = {
            {1, 0},
            {0, 1}
        };
        double[][] C = {
            {2, 3},
            {4, 5}
        };
        System.out.println("\nTest 3: Identity * 2x2");
        System.out.println("I:");
        printMat(I);
        System.out.println("C:");
        printMat(C);
        double[][] result3 = multiply(I, C);
        System.out.println("I * C:");
        printMat(result3);
        // Expected:
        // 2.0 3.0
        // 4.0 5.0

        // Test 4: 1x3 * 3x1
        double[][] A4 = {
            {1, 2, 3}
        };
        double[][] B4 = {
            {4},
            {5},
            {6}
        };
        System.out.println("\nTest 4: 1x3 * 3x1");
        System.out.println("A4:");
        printMat(A4);
        System.out.println("B4:");
        printMat(B4);
        double[][] result4 = multiply(A4, B4);
        System.out.println("A4 * B4:");
        printMat(result4);
        // Expected:
        // 32.0

        // Test 5: 3x1 * 1x3
        double[][] A5 = {
            {1},
            {2},
            {3}
        };
        double[][] B5 = {
            {4, 5, 6}
        };
        System.out.println("\nTest 5: 3x1 * 1x3");
        System.out.println("A5:");
        printMat(A5);
        System.out.println("B5:");
        printMat(B5);
        double[][] result5 = multiply(A5, B5);
        System.out.println("A5 * B5:");
        printMat(result5);
        // Expected:
        // 4.0 5.0 6.0
        // 8.0 10.0 12.0
        // 12.0 15.0 18.0
    }
}
