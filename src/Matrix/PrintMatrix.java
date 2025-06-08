package Matrix;

final public class PrintMatrix {
    // Improved printMat: aligns columns and formats numbers
    public static void printMat(double[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("(empty matrix)");
            return;
        }
        int cols = matrix[0].length;
        int[] colWidths = new int[cols];

        // Calculate max width for each column
        for (double[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                String formatted = String.format("%.4f", row[j]);
                colWidths[j] = Math.max(colWidths[j], formatted.length());
            }
        }

        // Print each row with aligned columns
        for (double[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                String formatted = String.format("%.4f", row[j]);
                System.out.print(" " + String.format("%" + colWidths[j] + "s", formatted));
            }
            System.out.println();
        }
    }
}
