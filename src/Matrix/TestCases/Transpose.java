package Matrix.TestCases;

import static Matrix.Operations.printMat;
import static Matrix.Operations.transpose;

// Transpose of matrix
// COMPLETE
final public class Transpose {
    // Test cases for transpose function
    public static void main(String[] args) {
        // Test 1: 2x2 matrix
        double[][] m1 = {
                {1, 2},
                {3, 4}
        };
        System.out.println("Test 1:");
        printMat(transpose(m1));

        // Test 2: 3x2 matrix
        double[][] m2 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        System.out.println("Test 2:");
        printMat(transpose(m2));

        // Test 3: 1x3 matrix
        double[][] m3 = {
                {7, 8, 9}
        };
        System.out.println("Test 3:");
        printMat(transpose(m3));

        // Test 4: 3x1 matrix
        double[][] m4 = {
                {10},
                {11},
                {12}
        };
        System.out.println("Test 4:");
        printMat(transpose(m4));

        // Test 5: 1x1 matrix
        double[][] m5 = {
                {42}
        };
        System.out.println("Test 5:");
        printMat(transpose(m5));
    }
}