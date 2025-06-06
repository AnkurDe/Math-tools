package Matrix;

// To generate zero matrix
final public class ZeroMatrix {
    // Inputs a matrix and returns a zero matrix of the same size
    public static double[][] zeros(double[][] input) {
        return zeros(input.length, input[0].length);
    }//Tested ok


    // Inputs the number of rows and columns and returns a zero matrix of that size
    public static double[][] zeros(int rows, int cols) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0.0;
            }
        }
        return result;
    }

    // Inputs the size of a square matrix and returns a zero matrix of that size
    public static double[][] zeros(int size) {
        return zeros(size, size);
    }
}
