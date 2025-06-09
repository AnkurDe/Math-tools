package Matrix;

import static Matrix.DiagonalProduct.diag_prod;
import static Matrix.Decomposition.lu;
import static Matrix.IsSquare.isSquare;

final public class Determinant {

    // To calculate the determinant of a matrix by LU decomposition
    public static double det(double[][] matrix) {
        if (!isSquare(matrix)){
            throw new MatrixError("Not a square matrix");
        }
        return diag_prod(lu(matrix)[1]);// Perform LU Decomposition
        // and get the diagonal product of Upper triangular matrix from LU Decomposition
    }
}