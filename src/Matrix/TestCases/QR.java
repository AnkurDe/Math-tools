package Matrix.TestCases;

import static Matrix.Decomposition.qr;
import static Matrix.Operations.multiply;
import static Matrix.Operations.printMat;

public class QR {
    public static void main(String[] args) {
        // Test 1: 2x2 matrix
        double[][] A1 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Test 1: 2x2 matrix");
        System.out.println("A1:");
        printMat(A1);
        double[][][] qr1 = qr(A1);
        System.out.println("Q:");
        printMat(qr1[0]);
        System.out.println("R:");
        printMat(qr1[1]);
        System.out.println("Q * R:");
        printMat(multiply(qr1[0], qr1[1]));
        // Expected: Q*R should reconstruct A1

        // Test 2: 3x2 matrix
        double[][] A2 = {
            {1, 0},
            {0, 1},
            {1, 1}
        };
        System.out.println("\nTest 2: 3x2 matrix");
        System.out.println("A2:");
        printMat(A2);
        double[][][] qr2 = qr(A2);
        System.out.println("Q:");
        printMat(qr2[0]);
        System.out.println("R:");
        printMat(qr2[1]);
        System.out.println("Q * R:");
        printMat(multiply(qr2[0], qr2[1]));
        // Expected: Q*R should reconstruct A2

        // Test 3: 3x3 identity matrix
        double[][] A3 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        System.out.println("\nTest 3: 3x3 identity matrix");
        System.out.println("A3:");
        printMat(A3);
        double[][][] qr3 = qr(A3);
        System.out.println("Q:");
        printMat(qr3[0]);
        System.out.println("R:");
        printMat(qr3[1]);
        System.out.println("Q * R:");
        printMat(multiply(qr3[0], qr3[1]));
        // Expected: Q and R should both be identity, Q*R = A3

        // Test 4: 2x3 matrix
        double[][] A4 = {
            {2, 3, 1},
            {4, 7, 7}
        };
        System.out.println("\nTest 4: 2x3 matrix");
        System.out.println("A4:");
        printMat(A4);
        double[][][] qr4 = qr(A4);
        System.out.println("Q:");
        printMat(qr4[0]);
        System.out.println("R:");
        printMat(qr4[1]);
        System.out.println("Q * R:");
        printMat(multiply(qr4[0], qr4[1]));
        // Expected: Q*R should reconstruct A4
    }
}
