package Matrix;

final public class Identity{
    // This class is a placeholder for generating Identify matrix

    public static double[][] eye(double[][] matrix) {
        return eye(matrix.length, matrix[0].length);
    }

    public static double[][] eye(int rows, int cols) {
        double[][] identity = new double[rows][cols];
        for (int i = 0; i < rows && i < cols; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }

    public static double[][] eye(int n) {
        return eye(n, n);
    }
}