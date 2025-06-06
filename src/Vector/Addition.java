package Vector;

import Matrix.MatrixError;

import java.util.stream.IntStream;

public class Addition {
    public static double[] add(double[] A, double[] B){
        if (A.length!=B.length){
            throw new MatrixError("Incorrect vector sizes");
        }
        return IntStream.range(0, A.length).mapToDouble(i -> A[i] + B[i]).toArray();
    }
}
