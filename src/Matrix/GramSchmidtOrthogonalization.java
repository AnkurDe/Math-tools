package Matrix;

import static Matrix.Transpose.transpose;
import static Vector.Subtraction.subtract;
import static Vector.Dot.dot;
import static Vector.Scale.scale;

public class GramSchmidtOrthogonalization {
    // Project v on u
    public static double[] proj(double[] v, double[] u) {
        return scale(u, dot(v,u)/dot(u, u));
    }

    public static double[][] GSO(double[][] matrix){
        return transpose(GSOt(matrix));
    }

    protected static double[][] GSOt(double[][] matrix) {
        if (matrix[0].length == 1) {
            return matrix.clone();
        }

        double[][] orig = transpose(matrix);
        double[][] ortho = new double[orig.length][orig[0].length];

        // There are orig.length number of vectors
        for (int i = 0; i < orig.length; i++) {
            double[] vec = orig[i];

            for (int j = 0; j < i; j++) {
                vec = subtract(vec, proj(orig[i], ortho[j]));
            }
            ortho[i] = vec;
        }
        return ortho;
    }
}
