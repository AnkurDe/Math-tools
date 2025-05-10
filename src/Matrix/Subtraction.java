package Matrix;

import static Matrix.Checker.checker;

// For performing subtraction
final public class Subtraction {
    public static double[][] Subtr(double[][] A, double[][] B) {
        checker(A, B);
        double[][] Subtract = new double[A.length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A.length; j++)
                Subtract[i][j] = (A[i][j] - B[i][j]);
        return Subtract;
    }//Tested ok
}
