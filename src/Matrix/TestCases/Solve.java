package Matrix.TestCases;

import static Matrix.Solve.solve;

public class Solve {
    // Test cases for the solve(double[][], double[]) function
    public static void testSolveVector() {
        // Test 1: Unique solution
        double[][] A1 = {
                {2, 1},
                {1, 3}
        };
        double[] B1 = {8, 13};
        double[] sol1 = solve(A1, B1);
        System.out.println("Vector Test 1 Solution:");
        for (double v : sol1) System.out.print(v + " ");
        System.out.println("\nExpected: 3.0 2.0\n");

        // Test 2: Identity matrix
        double[][] A2 = {
                {1, 0},
                {0, 1}
        };
        double[] B2 = {5, 7};
        double[] sol2 = solve(A2, B2);
        System.out.println("Vector Test 2 Solution:");
        for (double v : sol2) System.out.print(v + " ");
        System.out.println("\nExpected: 5.0 7.0\n");

        // Test 3: 3x3 system
        double[][] A3 = {
                {2, -1, 0},
                {-1, 2, -1},
                {0, -1, 2}
        };
        double[] B3 = {1, 0, 1};
        double[] sol3 = solve(A3, B3);
        System.out.println("Vector Test 3 Solution:");
        for (double v : sol3) System.out.print(v + " ");
        System.out.println("\nExpected: 1.0 1.0 1.0\n");

        // Test 4: Singular matrix (should throw)
        double[][] A4 = {
                {1, 2},
                {2, 4}
        };
        double[] B4 = {3, 6};
        try {
            double[] sol4 = solve(A4, B4);
            System.out.println("Vector Test 4 Solution:");
            for (double v : sol4) System.out.print(v + " ");
            System.out.println("\nExpected: Exception (Must be linearly independent)\n");
        } catch (Exception e) {
            System.out.println("Vector Test 4 Exception: " + e.getMessage());
        }

        // Test 5: Incorrect B shape (should throw)
        double[][] A5 = {
                {1, 2},
                {3, 4}
        };
        double[] B5 = {5, 6, 7};
        try {
            double[] sol5 = solve(A5, B5);
            System.out.println("Vector Test 5 Solution:");
            for (double v : sol5) System.out.print(v + " ");
            System.out.println("\nExpected: Exception (A and B must have the same number of rows)\n");
        } catch (Exception e) {
            System.out.println("Vector Test 5 Exception: " + e.getMessage());
        }
    }

    // Test cases for the solve function
    public static void main(String[] args) {
        // Test 1: Unique solution
        double[][] A1 = {
                {2, 1},
                {1, 3}
        };
        double[][] B1 = {
                {8},
                {13}
        };
        double[] sol1 = solve(A1, B1);
        System.out.println("Test 1 Solution:");
        for (double v : sol1) System.out.print(v + " ");
        System.out.println("\nExpected: 3.0 2.0\n");

        // Test 2: Identity matrix
        double[][] A2 = {
                {1, 0},
                {0, 1}
        };
        double[][] B2 = {
                {5},
                {7}
        };
        double[] sol2 = solve(A2, B2);
        System.out.println("Test 2 Solution:");
        for (double v : sol2) System.out.print(v + " ");
        System.out.println("\nExpected: 5.0 7.0\n");

        // Test 3: 3x3 system
        double[][] A3 = {
                {2, -1, 0},
                {-1, 2, -1},
                {0, -1, 2}
        };
        double[][] B3 = {
                {1},
                {0},
                {1}
        };
        double[] sol3 = solve(A3, B3);
        System.out.println("Test 3 Solution:");
        for (double v : sol3) System.out.print(v + " ");
        System.out.println("\nExpected: 1.0 1.0 1.0\n");

        // Test 4: Singular matrix (should throw)
        double[][] A4 = {
                {1, 2},
                {2, 4}
        };
        double[][] B4 = {
                {3},
                {6}
        };
        try {
            double[] sol4 = solve(A4, B4);
            System.out.println("Test 4 Solution:");
            for (double v : sol4) System.out.print(v + " ");
            System.out.println("\nExpected: Exception (Must be linearly independent)\n");
        } catch (Exception e) {
            System.out.println("Test 4 Exception: " + e.getMessage());
        }

        // Test 5: Incorrect B shape (should throw)
        double[][] A5 = {
                {1, 2},
                {3, 4}
        };
        double[][] B5 = {
                {5, 6}
        };
        try {
            double[] sol5 = solve(A5, B5);
            System.out.println("Test 5 Solution:");
            for (double v : sol5) System.out.print(v + " ");
            System.out.println("\nExpected: Exception (B must be a column vector)\n");
        } catch (Exception e) {
            System.out.println("Test 5 Exception: " + e.getMessage());
        }
        System.out.println("==== Testing solve(double[][], double[]) ====");
        testSolveVector();
    }
}
