package Matrix;

final public class Comply {
    // Checks compatibility for addition, subtraction, individual operation
    public static boolean compla(double[][] A, double[][] B) {
        return A.length != B.length || A[0].length != B[0].length;
    }// Not tested
}