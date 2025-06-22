package Vector;

import Matrix.MatrixError;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

/**
 * The Operations class provides static methods for common vector operations,
 * including addition, subtraction, dot product, scaling, normalization, and more.
 * These utilities are essential for linear algebra computations involving vectors.
 *
 * <p>
 * Methods include:
 * <ul>
 *   <li>Vector addition and subtraction</li>
 *   <li>Dot product and Euclidean norm</li>
 *   <li>Scaling and normalization</li>
 *   <li>Printing and zero vector creation</li>
 * </ul>
 * </p>
 */
public class Operations {
    /**
     * Adds two vectors element-wise.
     * @param A First vector.
     * @param B Second vector.
     * @return The sum vector.
     * @throws MatrixError if vector lengths do not match.
     */
    public static double[] add(double[] A, double[] B){
        if (A.length!=B.length){
            throw new MatrixError("Incorrect vector sizes");
        }
        return IntStream.range(0, A.length).mapToDouble(i -> A[i] + B[i]).toArray();
    }

    /**
     * Computes the dot product of two vectors.
     * @param A First vector.
     * @param B Second vector.
     * @return The dot product (scalar).
     * @throws MatrixError if vector lengths do not match.
     */
    public static double dot(double[] A, double[] B){
        if (A.length != B.length)
            throw new MatrixError("Matrices are incompatible for dot product because they are unequal length");

        return IntStream.range(0, A.length).mapToDouble(i -> A[i] * B[i]).sum();
    }

    /**
     * Computes the Euclidean norm (L2 norm) of a vector.
     * @param vector The input vector.
     * @return The norm (length) of the vector.
     */
    public static double norm(double[] vector){
        return sqrt(dot(vector,vector));
    }

    /**
     * Returns the normalized (unit) vector in the same direction as the input.
     * If the vector is zero, returns a copy of the original.
     * @param vector The input vector.
     * @return The normalized vector.
     */
    public static double[] normalise(double[] vector){
        double norm = norm(vector);
        if (norm == 0.0){
            return vector.clone();
        }
        return scale(vector, 1.0/norm);
    }

    /**
     * Prints the vector to standard output, formatted to two decimal places.
     * @param v The vector to print.
     */
    public static void printVec(double[] v) {
        for (double d : v) {
            System.out.printf("%.2f ", d);
        }
        System.out.println();
    }

    /**
     * Scales a vector by a given factor.
     * @param vector The input vector.
     * @param scalingFactor The factor to scale by.
     * @return The scaled vector.
     */
    public static double[] scale(double[] vector, double scalingFactor){
        return Arrays.stream(vector).map(v -> v * scalingFactor).toArray().clone();
//        setAll(vector, i -> vector[i] * scalingFactor);
//        return vector;
    }

    /**
     * Subtracts vector B from vector A element-wise.
     * @param A First vector.
     * @param B Second vector.
     * @return The difference vector.
     * @throws MatrixError if vector lengths do not match.
     */
    public static double[] subtract(double[] A, double[] B) {
        if (A.length!=B.length){
            throw new MatrixError("Incorrect vector sizes");
        }
        return IntStream.range(0, A.length).mapToDouble(i -> A[i] - B[i]).toArray();
    }

    /**
     * Returns a zero vector of length n.
     * @param n Length of the vector.
     * @return Zero vector.
     */
    public static double[] zeros(int n){
        return new double[n];
    }
}
