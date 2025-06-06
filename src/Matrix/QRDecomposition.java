package Matrix;

import static Matrix.GramSchmidtOrthonormalization.GSOrthonormalization;
import static Matrix.Multiplication.multiply;
import static Matrix.Transpose.transpose;
import static Matrix.PrintMatrix.printMat;

public class QRDecomposition {
    public static double[][][] qr(double[][] matrix){
        double[][] Q = GSOrthonormalization(matrix);
        double[][] R = multiply(transpose(Q), matrix);
        return new double[][][]{Q, R};
    }

    public static void main(String[] args) {
        // Test 1: 2x2 identity matrix
        double[][] matrix1 = {
            {1, 0},
            {0, 1}
        };
        runTest(matrix1, "Test 1: 2x2 Identity Matrix");

        // Test 2: 2x2 non-orthogonal matrix
        double[][] matrix2 = {
            {1, 1},
            {1, 0}
        };
        runTest(matrix2, "Test 2: 2x2 Non-Orthogonal Matrix");

        // Test 3: 3x3 matrix
        double[][] matrix3 = {
            {1, 1, 0},
            {1, 0, 1},
            {0, 1, 1}
        };
        runTest(matrix3, "Test 3: 3x3 Matrix");

        // Test 4: Matrix with linearly dependent columns
        double[][] matrix4 = {
            {1, 2},
            {2, 4}
        };
        runTest(matrix4, "Test 4: Linearly Dependent Columns");
    }

    private static void runTest(double[][] matrix, String testName) {
        System.out.println(testName);
        System.out.println("Original Matrix:");
        printMat(matrix);

        double[][][] qr = qr(matrix);
        double[][] Q = qr[0];
        double[][] R = qr[1];

        System.out.println("Q:");
        printMat(Q);
        System.out.println("R:");
        printMat(R);

        double[][] QR = multiply(Q, R);
        System.out.println("Q * R:");
        printMat(QR);

        System.out.println("=====================================");
    }
}
