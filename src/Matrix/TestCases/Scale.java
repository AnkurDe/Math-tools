package Matrix.TestCases;

import Matrix.Operations;

import static Matrix.Operations.printMat;
import static Matrix.Operations.scale;
import static Matrix.Operations.copy;

public class Scale {
    public static void main(String[] args) {
        // Test 1: Scale by 2
        double[][] mat1 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Original matrix:");
        printMat(mat1);
        System.out.println("Scaled by 2:");
        printMat(scale(2, copy(mat1)));
        // Expected: 2 4; 6 8

        // Test 2: Scale by -1
        System.out.println("\nScaled by -1:");
        printMat(scale(-1, copy(mat1)));
        // Expected: -1 -2; -3 -4

        // Test 3: Scale by 0
        System.out.println("\nScaled by 0:");
        printMat(scale(0, copy(mat1)));
        // Expected: 0 0; 0 0

        // Test 4: Scale identity matrix by 5
        double[][] id = Operations.eye(3);
        System.out.println("\nIdentity matrix scaled by 5:");
        printMat(scale(5, copy(id)));
        // Expected: 5 0 0; 0 5 0; 0 0 5
    }
}
