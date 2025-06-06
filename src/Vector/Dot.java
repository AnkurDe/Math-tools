package Vector;

import Matrix.MatrixError;

import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

public class Dot {
    public static double dot(double[] A, double[] B){
        if (A.length != B.length)
            throw new MatrixError("Matrices are incompatible for dot product because they are unequal length");

        return IntStream.range(0, A.length).mapToDouble(i -> A[i] * B[i]).sum();
    }

    public static class Norm {
        public static double norm(double[] vector){
            return sqrt(dot(vector,vector));
        }
    }
}
