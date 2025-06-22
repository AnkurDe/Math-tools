package Vector.TestCases;

import static Vector.Operations.*;


public class Zero {
    public static void main(String[] args) {
        // Test 1: Zero vector of size 3
        System.out.println("Test 1: Zero vector of size 3");
        double[] z1 = zeros(3);
        System.out.print("Zero vector: ");
        printVec(z1);
        System.out.println("Norm: " + norm(z1));
        // Expected: 0.00 0.00 0.00, norm = 0.00

        // Test 2: Zero vector of size 1
        System.out.println("\nTest 2: Zero vector of size 1");
        double[] z2 = zeros(1);
        System.out.print("Zero vector: ");
        printVec(z2);
        // Expected: 0.00

        // Test 3: Zero vector of size 5
        System.out.println("\nTest 3: Zero vector of size 5");
        double[] z3 = zeros(5);
        System.out.print("Zero vector: ");
        printVec(z3);
        // Expected: 0.00 0.00 0.00 0.00 0.00

        // Test 4: Adding zero vectors
        System.out.println("\nTest 4: Adding zero vectors");
        double[] z4 = zeros(2);
        double[] z5 = zeros(2);
        System.out.print("z4 + z5: ");
        printVec(add(z4, z5));
        // Expected: 0.00 0.00

        // Test 5: Zero vector of size 0
        System.out.println("\nTest 5: Zero vector of size 0");
        double[] z6 = zeros(0);
        System.out.print("Zero vector: ");
        printVec(z6);
        // Expected: (empty line)
    }
}
