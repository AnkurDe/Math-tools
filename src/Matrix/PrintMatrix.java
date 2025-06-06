package Matrix;

final public class PrintMatrix {
    // extends err
    public static void printMat(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("  " + doubles[j]);
            }
            System.out.println();
        }
    }
}
