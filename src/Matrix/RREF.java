package Matrix;

// For taking row reduced echelon form
final public class RREF {
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
