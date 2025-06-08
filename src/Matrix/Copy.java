package Matrix;

public class Copy {

    /**
     * Returns a deep copy of the given matrix.
     * @param mat The matrix to copy.
     * @return A new matrix with the same contents.
     */
    public static double[][] copy(double[][] mat) {
        double[][] out = new double[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            out[i] = mat[i].clone();
        }
        return out;
    }
}
