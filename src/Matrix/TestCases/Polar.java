package Matrix.TestCases;


import static Matrix.Decomposition.polar;
import static Matrix.Operations.multiply;
import static Matrix.Operations.printMat;

public class Polar {
    public static void main(String[] args) {
        // Test 1: 2x2 matrix
        double[][] A1 = {
            {2, 2},
            {1, 3}
        };
        System.out.println("Test 1: 2x2 matrix");
        System.out.println("A1:");
        printMat(A1);
        double[][][] polar1 = polar(A1);
        System.out.println("U (unitary/orthogonal part):");
        printMat(polar1[0]);
        System.out.println("P (positive semi-definite part):");
        printMat(polar1[1]);
        System.out.println("U * P (should reconstruct A1):");
        printMat(multiply(polar1[0], polar1[1]));

        // Test 2: 3x3 matrix
        double[][] A2 = {
            {1, 2, 3},
            {0, 1, 4},
            {5, 6, 0}
        };
        System.out.println("\nTest 2: 3x3 matrix");
        System.out.println("A2:");
        printMat(A2);
        double[][][] polar2 = polar(A2);
        System.out.println("U (unitary/orthogonal part):");
        printMat(polar2[0]);
        System.out.println("P (positive semi-definite part):");
        printMat(polar2[1]);
        System.out.println("U * P (should reconstruct A2):");
        printMat(multiply(polar2[0], polar2[1]));

        // Test 3: 2x2 identity matrix
        double[][] A3 = {
            {1, 0},
            {0, 1}
        };
        System.out.println("\nTest 3: 2x2 identity matrix");
        System.out.println("A3:");
        printMat(A3);
        double[][][] polar3 = polar(A3);
        System.out.println("U (unitary/orthogonal part):");
        printMat(polar3[0]);
        System.out.println("P (positive semi-definite part):");
        printMat(polar3[1]);
        System.out.println("U * P (should reconstruct A3):");
        printMat(multiply(polar3[0], polar3[1]));
    }
}
