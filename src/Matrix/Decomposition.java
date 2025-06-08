package Matrix;

import static Matrix.GramSchmidtOrthogonalization.GSO;
import static Matrix.Multiplication.multiply;
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
}
