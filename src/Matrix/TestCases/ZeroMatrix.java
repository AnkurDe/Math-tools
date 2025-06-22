package Matrix.TestCases;

import static Matrix.Operations.printMat;
import static Matrix.Operations.zeros;

// To generate zero matrix
final public class ZeroMatrix {
    public static void main(String[] args) {
        // Test 1: 3x3 zero matrix
        System.out.println("3x3 Zero Matrix:");
        double[][] z1 = zeros(3, 3);
        printMat(z1);

        // Test 2: 2x4 zero matrix
        System.out.println("\n2x4 Zero Matrix:");
        double[][] z2 = zeros(2, 4);
        printMat(z2);

        // Test 3: 4x2 zero matrix
        System.out.println("\n4x2 Zero Matrix:");
        double[][] z3 = zeros(4, 2);
        printMat(z3);

        // Test 4: Zero matrix from the shape of another matrix
        double[][] shape = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("\nZero matrix from shape (2x3):");
        double[][] z4 = zeros(shape);
        printMat(z4);

        // Test 5: 1x1 zero matrix
        System.out.println("\n1x1 Zero Matrix:");
        double[][] z5 = zeros(1, 1);
        printMat(z5);
    }
}
