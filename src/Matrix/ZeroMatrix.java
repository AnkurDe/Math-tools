package Matrix;

// To generate zero matrix
final public class ZeroMatrix {
    // Inputs a matrix and returns a zero matrix of the same size
    public static double[][] Zeros(double[][] input) {
        for (int i = 0; i < input.length; i++) {
            int j;
            for (j = 0; j < input[0].length; j++) {
                input[i][j] = 0.0;
            }
        }
        return input;
    }//Tested ok


    // Inputs the number of rows and columns and returns a zero matrix of that size
    public static double[][] Zeros(int rows, int cols) {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0.0;
            }
        }
        return result;
    }

    // Inputs the size of a square matrix and returns a zero matrix of that size
    public static double[][] Zeros(int size) {
        return Zeros(size, size);
    }
}
