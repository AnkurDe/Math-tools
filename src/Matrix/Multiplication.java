package Matrix;

//import static Matrix.PrintMatrix.printMat;

// To perform matrix multiplication
final public class Multiplication{
    public static double[][] multiply(double[][] A, double[][] B) {
        // Correct dimension check: columns of A == rows of B
        if (A[0].length != B.length) {
            throw new DimensionErrorException("The matrices are not compatible for multiplication");
        }
        double[][] result = new double[A.length][B[0].length];
        ZeroMatrix.zeros(result);
        //rows
        for (int i = 0; i < A.length; i++) {
            //columns
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

//    // Test cases for multiply
//    public static void main(String[] args) {
//        // Test 1: 2x2 * 2x2
//        double[][] A1 = {
//            {1, 2},
//            {3, 4}
//        };
//        double[][] B1 = {
//            {5, 6},
//            {7, 8}
//        };
//        double[][] result1 = multiply(A1, B1);
//        System.out.println("Test 1 Result:");
//        printMat(result1);
//        // Expected:
//        // 19.0 22.0
//        // 43.0 50.0
//
//        // Test 2: 2x3 * 3x2
//        double[][] A2 = {
//            {1, 2, 3},
//            {4, 5, 6}
//        };
//        double[][] B2 = {
//            {7, 8},
//            {9, 10},
//            {11, 12}
//        };
//        double[][] result2 = multiply(A2, B2);
//        System.out.println("Test 2 Result:");
//        printMat(result2);
//        // Expected:
//        // 58.0 64.0
//        // 139.0 154.0
//
//        // Test 3: Identity matrix
//        double[][] I = {
//            {1, 0},
//            {0, 1}
//        };
//        double[][] C = {
//            {2, 3},
//            {4, 5}
//        };
//        double[][] result3 = multiply(I, C);
//        System.out.println("Test 3 Result:");
//        printMat(result3);
//        // Expected:
//        // 2.0 3.0
//        // 4.0 5.0
//
//        // Test 4: 1x3 * 3x1
//        double[][] A4 = {
//            {1, 2, 3}
//        };
//        double[][] B4 = {
//            {4},
//            {5},
//            {6}
//        };
//        double[][] result4 = multiply(A4, B4);
//        System.out.println("Test 4 Result:");
//        printMat(result4);
//        // Expected:
//        // 32.0
//
//        // Test 5: 3x1 * 1x3
//        double[][] A5 = {
//            {1},
//            {2},
//            {3}
//        };
//        double[][] B5 = {
//            {4, 5, 6}
//        };
//        double[][] result5 = multiply(A5, B5);
//        System.out.println("Test 5 Result:");
//        printMat(result5);
//        // Expected:
//        // 4.0 5.0 6.0
//        // 8.0 10.0 12.0
//        // 12.0 15.0 18.0
//    }
}
