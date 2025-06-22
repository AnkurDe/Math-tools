package Vector.TestCases;

import static Vector.Operations.*;
import static java.lang.Math.sqrt;

public class Normalize {
    public static void main(String[] args) {
        // Test 1: Regular vector
        double[] v1 = {3, 4};
        System.out.println("Test 1: Regular vector");
        System.out.print("Original vector: ");
        printVec(v1);
        System.out.print("Normalized vector: ");
        printVec(normalise(v1));
        System.out.println("Norm of normalized vector: " + norm(normalise(v1)));
        // Expected: 0.60 0.80, norm should be 1.0

        // Test 2: Zero vector
        double[] v2 = zeros(3);
        System.out.println("\nTest 2: Zero vector");
        System.out.print("Original vector: ");
        printVec(v2);
        System.out.print("Normalized vector: ");
        printVec(normalise(v2));
        System.out.println("Norm of normalized vector: " + norm(normalise(v2)));
        // Expected: 0.00 0.00 0.00, norm should be 0.0

        // Test 3: Already normalized vector
        double[] v3 = {1.0 / sqrt(2), 1.0 / sqrt(2)};
        System.out.println("\nTest 3: Already normalized vector");
        System.out.print("Original vector: ");
        printVec(v3);
        System.out.print("Normalized vector: ");
        printVec(normalise(v3));
        System.out.println("Norm of normalized vector: " + norm(normalise(v3)));
        // Expected: ~0.71 0.71, norm should be 1.0

        // Test 4: Vector with negative components
        double[] v4 = {-3, 4};
        System.out.println("\nTest 4: Vector with negative components");
        System.out.print("Original vector: ");
        printVec(v4);
        System.out.print("Normalized vector: ");
        printVec(normalise(v4));
        System.out.println("Norm of normalized vector: " + norm(normalise(v4)));
        // Expected: -0.60 0.80, norm should be 1.0

        // Test 5: Large magnitude vector
        double[] v5 = {1000, 1000};
        System.out.println("\nTest 5: Large magnitude vector");
        System.out.print("Original vector: ");
        printVec(v5);
        System.out.print("Normalized vector: ");
        printVec(normalise(v5));
        System.out.println("Norm of normalized vector: " + norm(normalise(v5)));
        // Expected: ~0.71 0.71, norm should be 1.0
    }
}

