package Vector;

import Matrix.MatrixError;

import java.util.stream.IntStream;

//import static Vector.Norm.norm;

public class Dot {
    public static double dot(double[] A, double[] B){
        if (A.length != B.length)
            throw new MatrixError("Matrices are incompatible for dot product because they are unequal length");

        return IntStream.range(0, A.length).mapToDouble(i -> A[i] * B[i]).sum();
    }

//
//    // Test cases for dot and norm
//    public static void main(String[] args) {
//        // Test 1: Dot product of two positive vectors
//        double[] v1 = {1, 2, 3};
//        double[] v2 = {4, 5, 6};
//        System.out.printf("Test 1 (dot): %.2f\n", dot(v1, v2)); // Expected: 32.00
//
//        // Test 2: Dot product with negative numbers
//        double[] v3 = {-1, -2, -3};
//        double[] v4 = {1, 2, 3};
//        System.out.printf("Test 2 (dot): %.2f\n", dot(v3, v4)); // Expected: -14.00
//
//        // Test 3: Dot product with zeros
//        double[] v5 = {0, 0, 0};
//        double[] v6 = {7, 8, 9};
//        System.out.printf("Test 3 (dot): %.2f\n", dot(v5, v6)); // Expected: 0.00
//
//        // Test 4: Dot product of orthogonal vectors
//        double[] v7 = {1, 0};
//        double[] v8 = {0, 1};
//        System.out.printf("Test 4 (dot): %.2f\n", dot(v7, v8)); // Expected: 0.00
//
//        // Test 5: Norm of a vector
//        double[] v9 = {3, 4};
//        System.out.printf("Test 5 (norm): %.2f\n", norm(v9)); // Expected: 5.00
//
//        // Test 6: Norm of a zero vector
//        double[] v10 = {0, 0, 0};
//        System.out.printf("Test 6 (norm): %.2f\n", norm(v10)); // Expected: 0.00
//
//        // Test 7: Exception for unequal length
//        double[] v11 = {1, 2};
//        double[] v12 = {1, 2, 3};
//        try {
//            dot(v11, v12);
//            System.out.println("Test 7 (dot): Failed (no exception thrown)");
//        } catch (MatrixError e) {
//            System.out.println("Test 7 (dot): Passed (exception thrown)");
//        }
//    }
}
