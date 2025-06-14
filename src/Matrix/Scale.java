package Matrix;

public class Scale {
    public static double[][] scale(double scale, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scale * matrix[i][j];
            }
        }
        return matrix.clone();
    }
}
