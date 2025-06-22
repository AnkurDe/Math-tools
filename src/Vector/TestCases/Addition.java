package Vector.TestCases;

import static Vector.Operations.*;

public class Addition {
    public static void main(String[] args) {
        // Test 1: Regular vector addition
        double[] v1 = {1, 2, 3};
        double[] v2 = {4, 5, 6};
        System.out.println("Test 1: Regular vector addition");
        System.out.print("v1: ");
        printVec(v1);
        System.out.print("v2: ");
        printVec(v2);
        System.out.print("v1 + v2: ");
        printVec(add(v1, v2));
        // Expected: 5.00 7.00 9.00

        // Test 2: Addition with zero vectors
        double[] v3 = {1, 2, 3};
        double[] zero = zeros(3);
        System.out.println("\nTest 2: Addition with zero vector");
        System.out.print("v3: ");
        printVec(v3);
        System.out.print("zero: ");
        printVec(zero);
        System.out.print("v3 + zero: ");
        printVec(add(v3, zero));
        // Expected: 1.00 2.00 3.00

        // Test 3: Addition of negative numbers
        double[] v4 = {-1, -2, -3};
        double[] v5 = {1, 2, 3};
        System.out.println("\nTest 3: Addition with negative numbers");
        System.out.print("v4: ");
        printVec(v4);
        System.out.print("v5: ");
        printVec(v5);
        System.out.print("v4 + v5: ");
        printVec(add(v4, v5));
        // Expected: 0.00 0.00 0.00

        // Test 4: Mismatched sizes (should throw error)
        double[] v6 = {1, 2};
        double[] v7 = {1, 2, 3};
        System.out.println("\nTest 4: Mismatched sizes");
        System.out.print("v6: ");
        printVec(v6);
        System.out.print("v7: ");
        printVec(v7);
        try {
            printVec(add(v6, v7));
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
