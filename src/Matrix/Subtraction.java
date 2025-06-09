package Matrix;

import static Matrix.Checker.checker;

// For performing subtraction
final public class Subtraction {
    public static double[][] sub(double[][] A, double[][] B) {

        if (A.length != B.length) {
            throw new MatrixCorruptException("Mismatch in number of rows of matrices");
        }
        if (A[0].length != B[0].length){
            throw new MatrixCorruptException("Mismatch in number of columns of matrices");
        }

        double[][] Subtract = new double[A.length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A.length; j++)
                Subtract[i][j] = (A[i][j] - B[i][j]);
        return Subtract;
    }//Tested ok
}
