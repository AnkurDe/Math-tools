package Vector.TestCases;

import static Vector.Operations.*;

public class Subtraction {
    public static void main(String[] args) {
        // Test 1: Regular vector subtraction
        double[] v1 = {4, 5, 6};
        double[] v2 = {1, 2, 3};
        System.out.println("Test 1: Regular vector subtraction");
        System.out.print("v1: ");
        printVec(v1);
        System.out.print("v2: ");
        printVec(v2);
        System.out.print("v1 - v2: ");
        printVec(subtract(v1, v2));
        // Expected: 3.00 3.00 3.00

        // Test 2: Subtraction with zero vector
        double[] v3 = {1, 2, 3};
        double[] zero = zeros(3);
        System.out.println("\nTest 2: Subtraction with zero vector");
        System.out.print("v3: ");
        printVec(v3);
        System.out.print("zero: ");
        printVec(zero);
        System.out.print("v3 - zero: ");
        printVec(subtract(v3, zero));
        // Expected: 1.00 2.00 3.00

        // Test 3: Subtracting vector from itself
        double[] v4 = {1, 2, 3};
        System.out.println("\nTest 3: Subtracting vector from itself");
        System.out.print("v4: ");
        printVec(v4);
        System.out.print("v4 - v4: ");
        printVec(subtract(v4, v4));
        // Expected: 0.00 0.00 0.00

        // Test 4: Mismatched sizes (should throw error)
        double[] v5 = {1, 2};
        double[] v6 = {1, 2, 3};
        System.out.println("\nTest 4: Mismatched sizes");
        System.out.print("v5: ");
        printVec(v5);
        System.out.print("v6: ");
        printVec(v6);
        try {
            printVec(subtract(v5, v6));
            System.out.println("Failed test case");
        } catch (Exception e) {
            System.out.println("Passed Test case with error message: " + e.getMessage());
        }
    }
}
