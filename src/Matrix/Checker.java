package Matrix;

import static Matrix.IsCorrupt.isCorrupt;

// To check if two matrices are corrupted or not
final public class Checker {
    static void multChecker(double[][] A, double[][] B) {
        if (A.length != B.length || A[0].length != B[0].length) {
            throw new MatrixCorruptException("The operation number of rows or columns of matrix is not the same");
        }

        if (isCorrupt(A) || isCorrupt(B)) {
            throw new MatrixCorruptException("Either of the given matrix is corrupted");
        }
    }// Tested Ok
}
