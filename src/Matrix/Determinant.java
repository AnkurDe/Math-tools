package Matrix;

import static Matrix.DiagonalProduct.diag_prod;
import static Matrix.Matrix.lu;

final public class Determinant {

    // To calculate the determinant of a matrix by LU decomposition
    public static double det(double[][] matrix) {
        return diag_prod(lu(matrix)[1]);// Perform LU Decomposition
        // and get the diagonal product of Upper triangular matrix from LU Decomposition
    }
}