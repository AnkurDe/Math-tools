package Matrix;

import static Matrix.ZeroMatrix.zeros;
import static Matrix.Comply.complm;

// To perform matrix multiplication
final public class Multiplication {
    public static double[][] multiply(double[][] A, double[][] B) {
        complm(A, B);
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
    }//Tested ok
}
