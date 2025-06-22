package Vector.TestCases;

import static Vector.Operations.*;

public class Norm {
    public static void main(String[] args) {
        // Test 1: Unit vector
        double[] v1 = {1, 0, 0};
        System.out.println("Test 1: Unit vector");
        System.out.print("v1: ");
        printVec(v1);
        System.out.println("Norm: " + norm(v1));
        // Expected: 1.00

        // Test 2: Regular vector
        double[] v2 = {3, 4};
        System.out.println("\nTest 2: Regular vector (3,4)");
        System.out.print("v2: ");
        printVec(v2);
        System.out.println("Norm: " + norm(v2));
        // Expected: 5.00

        // Test 3: Zero vector
        double[] v3 = zeros(3);
        System.out.println("\nTest 3: Zero vector");
        System.out.print("v3: ");
        printVec(v3);
        System.out.println("Norm: " + norm(v3));
        // Expected: 0.00

        // Test 4: Negative components
        double[] v4 = {-1, -2, 2};
        System.out.println("\nTest 4: Vector with negative components");
        System.out.print("v4: ");
        printVec(v4);
        System.out.println("Norm: " + norm(v4));
        // Expected: 3.00

        // Test 5: Normalize vector
        double[] v5 = {3, 4};
        System.out.println("\nTest 5: Normalizing vector (3,4)");
        System.out.print("Original vector: ");
        printVec(v5);
        double[] normalized = normalise(v5);
        System.out.print("Normalized vector: ");
        printVec(normalized);
        System.out.println("Norm of normalized vector: " + norm(normalized));
        // Expectedly normalized: 0.60 0.80
        // Expected norm: 1.00
    }
}
