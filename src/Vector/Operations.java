package Vector;

import Matrix.MatrixError;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

public class Operations {
    public static double[] add(double[] A, double[] B){
        if (A.length!=B.length){
            throw new MatrixError("Incorrect vector sizes");
        }
        return IntStream.range(0, A.length).mapToDouble(i -> A[i] + B[i]).toArray();
    }

    public static double dot(double[] A, double[] B){
        if (A.length != B.length)
            throw new MatrixError("Matrices are incompatible for dot product because they are unequal length");

        return IntStream.range(0, A.length).mapToDouble(i -> A[i] * B[i]).sum();
    }

    public static double norm(double[] vector){
        return sqrt(dot(vector,vector));
    }

    public static double[] normalise(double[] vector){
        double norm = norm(vector);
        if (norm == 0.0){
            return vector.clone();
        }
        return scale(vector, 1.0/norm);
    }

    public static void printVec(double[] v) {
        for (double d : v) {
            System.out.printf("%.2f ", d);
        }
        System.out.println();
    }

    public static double[] scale(double[] vector, double scalingFactor){
        return Arrays.stream(vector).map(v -> v * scalingFactor).toArray().clone();
//        setAll(vector, i -> vector[i] * scalingFactor);
//        return vector;
    }

    public static double[] subtract(double[] A, double[] B) {
        if (A.length!=B.length){
            throw new MatrixError("Incorrect vector sizes");
        }
        return IntStream.range(0, A.length).mapToDouble(i -> A[i] - B[i]).toArray();
    }

    public static double[] zeros(int n){
        return new double[n];
    }
}
