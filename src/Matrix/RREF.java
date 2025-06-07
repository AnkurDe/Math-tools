package Matrix;

// For taking row reduced the echelon form
/**
 * RREF provides a static method to compute the Row Reduced Echelon Form (RREF) of a matrix.
 * 
 * The main method demonstrates usage with several test cases.
 * 
 * Algorithm:
 * - For each row, find the leftmost nonzero column (the "lead").
 * - Swap the current row with a row below if needed to get a nonzero lead.
 * - Normalize the row so the lead is 1.
 * - Eliminate all other entries in the lead column by subtracting suitable multiples of the current row from the others.
 * - Repeat for the next row and next column.
 * 
 * Helper methods:
 * - printMatrix: Nicely prints a matrix to the console.
 * - copy: Deep-copies a matrix to avoid mutating test data.
 */
final public class RREF {
    /**
     * Computes the Row Reduced Echelon Form (RREF) of the given matrix in-place.
     * @param matrix The matrix to reduce (will be modified).
     * @return The RREF of the matrix.
     */
    public static double[][] rref(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lead = 0;

        for (int r = 0; r < rows; r++) {
            if (lead >= cols) break;
            int i = r;
            while (matrix[i][lead] == 0) {
                i++;
                if (i == rows) {
                    i = r;
                    lead++;
                    if (lead == cols) return matrix;
                }
            }

            // Swap rows i and r
            double[] temp = matrix[i];
            matrix[i] = matrix[r];
            matrix[r] = temp;

            // Normalize the row by making the lead element 1
            double leadValue = matrix[r][lead];
            for (int j = 0; j < cols; j++) {
                matrix[r][j] /= leadValue;
            }

            // Eliminate all other entries in the lead column
            for (int k = 0; k < rows; k++) {
                if (k != r) {
                    double factor = matrix[k][lead];
                    for (int j = 0; j < cols; j++) {
                        matrix[k][j] -= factor * matrix[r][j];
                    }
                }
            }
            lead++;
        }
        return matrix;
    }
}
