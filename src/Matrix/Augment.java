package Matrix;

public final class Augment {

    // To be tested
    public static double[][] aug(double[][] A, double[][] B, char operation) {
        ;
        if (Character.toUpperCase(operation) == 'R') {
            return augRow(A, B);
        } else if (Character.toUpperCase(operation) == 'C') {
            return augCol(A, B);
        } else {
            throw new IllegalArgumentException("Invalid operation " + operation);
        }
    }

    // To be tested
    // Augment to column side A|B
    public static double[][] augRow(double[][] A, double[][] B) {
        if (A.length != B.length) {
            throw new MatrixError("Number of rows of both matrices must be equal");
        }
        double[][] result = new double[A.length][A[0].length + B[0].length];
        for (int i = 0; i < A.length; i++) {
            System.arraycopy(A[i], 0, result[i], 0, A[0].length);
            System.arraycopy(B[i], 0, result[i], A[0].length, B[0].length);
        }
        return result;
    }

    // To be tested
    public static double[][] augCol(double[][] A, double[][] B) {
        if (A[0].length != B[0].length) {
            throw new MatrixError("Number of columns of both matrices must be equal");
        }
        double[][] result = new double[A.length + B.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            System.arraycopy(A[i], 0, result[i], 0, A[0].length);
        }
        for (int i = 0; i < B.length; i++) {
            System.arraycopy(B[i], 0, result[i + A.length], 0, B[0].length);
        }
        return result;
    }
}
