package Matrix;

import java.util.stream.IntStream;

import static Matrix.GramSchmidtOrthogonalization.GSOt;
import static Matrix.Transpose.transpose;
import static Vector.Normalize.normalise;

public class GramSchmidtOrthonormalization {
    public static double[][] GSOrthonormalization(double[][] matrix) {
        double[][] A = GSOt(matrix);
        IntStream.range(0, A.length).forEach(i -> A[i] = normalise(A[i]));
        return transpose(A);
    }
}
