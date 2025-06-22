package Matrix.TestCases;


import Matrix.MatrixError;

import static Matrix.Operations.printMat;
import static Matrix.Operations.inv;
import static Matrix.Operations.multiply;
import static Matrix.Operations.leftInv;
import static Matrix.Operations.rightInv;
import static Matrix.Operations.pinv;

final public class Inverse
{
    public static void main(String[] args) {
        // Full rank matrix
        System.out.println("Inverse of 2x2 matrix:");
        printMat(inv(new double[][]{
                {2,3},
                {4,5},
        }));

        // Not full rank matrix (should throw)
        try {
            System.out.println("Inverse of singular 3x3 matrix:");
            printMat(inv(new double[][]{
                    {2, 3, 1},
                    {4, 6, 2},
                    {1, 1.5, 0.5}
            }));
        } catch (MatrixError e) {
            System.out.println("Not invertible");
        }

        // Full rank 3x3 matrix
        System.out.println("Inverse of 3x3 matrix:");
        printMat(inv(new double[][]{
                {2,3,1},
                {4,5,1},
                {1,1,2}
        }));

        // Test Right Inverse (rightInv) for a 2x3 full row rank matrix
        double[][] A1 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("Right Inverse (rightInv) of 2x3 matrix:");
        printMat(rightInv(A1));
        // Expected: A1 * rightInv(A1) ≈ I (2x2 identity)
        System.out.println("A1 * rightInv(A1):");
        printMat(multiply(A1, rightInv(A1)));

        // Test Left Inverse (leftInv) for a 3x2 full column rank matrix
        double[][] A2 = {
            {1, 4},
            {2, 5},
            {3, 6}
        };
        System.out.println("Left Inverse (leftInv) of 3x2 matrix:");
        printMat(leftInv(A2));
        // Expected: leftInv(A2) * A2 ≈ I (2x2 identity)
        System.out.println("leftInv(A2) * A2:");
        printMat(multiply(leftInv(A2), A2));

        // Test: rightInv(A1) * A1 ≈ I (3x3 identity, but not expected to be identity for non-square)
        System.out.println("rightInv(A1) * A1:");
        printMat(multiply(rightInv(A1), A1));

        // Test: A2 * leftInv(A2) ≈ I (3x3 identity, but not expected to be identity for non-square)
        System.out.println("A2 * leftInv(A2):");
        printMat(multiply(A2, leftInv(A2)));

        // Test: Inverse does not exist (singular square matrix)
        try {
            System.out.println("Inverse of singular 2x2 matrix:");
            printMat(inv(new double[][]{
                {1, 2},
                {2, 4}
            }));
        } catch (MatrixError e) {
            System.out.println("Inverse does not exist (singular matrix)");
        }

        // Test: Right inverse does not exist (not full row rank)
        double[][] B1 = {
            {1, 2, 3},
            {2, 4, 6}
        };
        try {
            System.out.println("Right Inverse (rightInv) does not exist for:");
            printMat(rightInv(B1));
        } catch (MatrixError e) {
            System.out.println("Right Inverse does not exist (not full row rank)");
        }

        // Test: Left inverse does not exist (not full column rank)
        double[][] B2 = {
            {1, 2},
            {2, 4},
            {3, 6}
        };
        try {
            System.out.println("Left Inverse (leftInv) does not exist for:");
            printMat(leftInv(B2));
        } catch (MatrixError e) {
            System.out.println("Left Inverse does not exist (not full column rank)");
        }

        // Additional test cases for right inverse, left inverse, and pseudoinverse

        // Right inverse: 2x4 full row rank (rows < cols, rank 2)
        double[][] C1 = {
            {1, 2, 0, 0},
            {0, 0, 3, 4}
        };
        System.out.println("Right Inverse (rightInv) of 2x4 matrix:");
        printMat(rightInv(C1));
        System.out.println("C1 * rightInv(C1):");
        printMat(multiply(C1, rightInv(C1))); // Should be close to 2x2 identity

        // Left inverse: 4x2 full column rank (rows > cols, rank 2)
        double[][] C2 = {
            {1, 0},
            {2, 0},
            {0, 3},
            {0, 4}
        };
        System.out.println("Left Inverse (leftInv) of 4x2 matrix:");
        printMat(leftInv(C2));
        System.out.println("leftInv(C2) * C2:");
        printMat(multiply(leftInv(C2), C2)); // Should be close to 2x2 identity

        // Pseudoinverse: tall matrix (3x2, full column rank)
        double[][] D1 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        System.out.println("Pseudoinverse (pinv) of 3x2 matrix:");
        printMat(pinv(D1));
        System.out.println("pinv(D1) * D1:");
        printMat(multiply(pinv(D1), D1)); // Should be close to 2x2 identity

        // Pseudoinverse: wide matrix (2x3, full row rank)
        double[][] D2 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("Pseudoinverse (pinv) of 2x3 matrix:");
        printMat(pinv(D2));
        System.out.println("D2 * pinv(D2):");
        printMat(multiply(D2, pinv(D2))); // Should be close to 2x2 identity

        // Pseudoinverse: rank-deficient matrix (should not be full-rank identity)
        double[][] D3 = {
            {1, 2, 3},
            {2, 4, 6},
            {3, 6, 9}
        };
        try {
            System.out.println("Pseudoinverse (pinv) of rank-deficient 3x3 matrix:");
            printMat(pinv(D3));
            System.out.println("D3 * pinv(D3):");
            printMat(multiply(D3, pinv(D3)));
        } catch (MatrixError e) {
            System.out.println("Pseudoinverse does not exist (rank-deficient matrix)");
        }

        // Pseudoinverse: non-square, rank-deficient
        double[][] D4 = {
            {1, 2, 3},
            {2, 4, 6}
        };
        try {
            System.out.println("Pseudoinverse (pinv) of rank-deficient 2x3 matrix:");
            printMat(pinv(D4));
            System.out.println("D4 * pinv(D4):");
            printMat(multiply(D4, pinv(D4)));
        } catch (MatrixError e) {
            System.out.println("Pseudoinverse does not exist (rank-deficient matrix)");
        }
    }
}