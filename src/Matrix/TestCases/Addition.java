package Matrix.TestCases;

import static Matrix.Operations.addition;
import static Matrix.Operations.printMat;

// For performing Addition
final public class Addition {


    public static void main(String[] args) {
        // Test 1: Correct addition
        double[][] A = {
            {1, 2},
            {3, 4}
        };
        double[][] B = {
            {5, 6},
            {7, 8}
        };
        System.out.println("Test 1: Correct addition");
        double[][] sum = addition(A, B);
        printMat(sum);
        // Expected:
        // 6.0 8.0
        // 10.0 12.0

        // Test 2: Mismatched rows
        double[][] C = {
            {1, 2}
        };
        try {
            System.out.println("Test 2: Mismatched rows");
            addition(A, C);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            // Expected: Mismatch in number of rows of matrices
        }

        // Test 3: Mismatched columns
        double[][] D = {
            {1, 2, 3},
            {4, 5, 6}
        };
        try {
            System.out.println("Test 3: Mismatched columns");
            addition(A, D);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            // Expected: Mismatch in number of columns of matrices
        }
    }
}