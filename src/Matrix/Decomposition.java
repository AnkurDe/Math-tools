package Matrix;

import static Matrix.GramSchmidtOrthogonalization.GSO;
import static Matrix.Multiplication.multiply;
import static Matrix.PrintMatrix.printMat;
import static Matrix.Transpose.transpose;

public class Decomposition {
    public static double[][][] svd(double[] matrix){
        return null;
    }

    public static double[][][] qr(double[][] matrix){
        double[][] Q = GSO(matrix);
        double[][] R = multiply(transpose(Q), matrix);
        return new double[][][]{Q, R};
    }

    public static double[][][] lu(double[][] A) {
        int n = A.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    L[i][j] = 1.0;
                } else {
                    L[i][j] = 0.0;
                }
                U[i][j] = A[i][j];
            }
        }

        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                L[i][k] = U[i][k] / U[k][k];
                for (int j = k; j < n; j++) {
                    U[i][j] -= L[i][k] * U[k][j];
                }
            }
        }

        return new double[][][]{L, U};
    }

//    private static void QRTest() {
//        // Test 1: 2x2 identity matrix
//        double[][] matrix1 = {
//            {1, 0},
//            {0, 1}
//        };
//        runQRTest(matrix1, "Test 1: 2x2 Identity Matrix");
//
//        // Test 2: 2x2 non-orthogonal matrix
//        double[][] matrix2 = {
//            {1, 1},
//            {1, 0}
//        };
//        runQRTest(matrix2, "Test 2: 2x2 Non-Orthogonal Matrix");
//
//        // Test 3: 3x3 matrix
//        double[][] matrix3 = {
//            {1, 1, 0},
//            {1, 0, 1},
//            {0, 1, 1}
//        };
//        runQRTest(matrix3, "Test 3: 3x3 Matrix");
//
//        // Test 4: Matrix with linearly dependent columns
//        double[][] matrix4 = {
//            {1, 2},
//            {2, 4}
//        };
//        runQRTest(matrix4, "Test 4: Linearly Dependent Columns");
//    }
//
//    private static void runQRTest(double[][] matrix, String testName) {
//        System.out.println(testName);
//        System.out.println("Original Matrix:");
//        printMat(matrix);
//
//        double[][][] qr = qr(matrix);
//        double[][] Q = qr[0];
//        double[][] R = qr[1];
//
//        System.out.println("Q:");
//        printMat(Q);
//        System.out.println("R:");
//        printMat(R);
//
//        double[][] QR = multiply(Q, R);
//        System.out.println("Q * R:");
//        printMat(QR);
//
//        System.out.println("=====================================");
//    }
//
//    public static void main(String[] args) {
//        QRTest();
//    }

}
