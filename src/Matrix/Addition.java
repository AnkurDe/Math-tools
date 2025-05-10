package Matrix;

import static Matrix.Checker.checker;

// For performing Addition
final public class Addition {
    public static double[][] Add(double[][] A, double[][] B) {
        checker(A, B);
        double[][] Sum = new double[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                Sum[i][j] = A[i][j] + B[i][j];
            }
        }
        return Sum;
    }// Tested Ok
}
