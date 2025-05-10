package Matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

final public class GaussianElimination {
    // Incomplete
    public static double[] Rowop2(double[] A, double[] B, char op){
        // Incomplete
//        if (A.length != B.length){
//            throw new MatrixError("");
//        }
        return switch (Character.toUpperCase(op)) {
            case 'A' ->
                //Addition
                    IntStream.range(0, A.length).mapToDouble(i -> A[i] + B[i]).toArray();
            case 'S' ->
                // Subtraction
                    IntStream.range(0, A.length).mapToDouble(i -> A[i] - B[i]).toArray();
            case 'M' ->
                // Individual element multiplication
                    IntStream.range(0, A.length).mapToDouble(i -> A[i] * B[i]).toArray();
            default -> new double[]{0.0, 0.0};
        };
    }

    public static double[] Rowop1(double[] A, double n, char op){
        // Incomplete
//        if (A.length != B.length){
//            throw new MatrixError("");
//        }
        return switch (Character.toUpperCase(op)) {
            case 'A' ->
                //Addition
                    Arrays.stream(A).map(v -> v + n).toArray();
            case 'S' ->
                // Subtraction
                    Arrays.stream(A).map(v -> v - n).toArray();
            case 'M' ->
                // Multiplication
                    Arrays.stream(A).map(v -> v * n).toArray();
            case 'D' ->
                // Division
                    Arrays.stream(A).map(v -> v / n).toArray();
            default -> new double[]{0.0, 0.0};
        };
    }

    // Erroranious
    public double[][] UpperTriangularMatr(double[][] A){
        int rows = A.length, cols = A[0].length, pivotRow, j = 0;
        for (pivotRow = 0; pivotRow < rows && pivotRow < cols; pivotRow++){// Choosing the pivotal element - Row wise
            A[pivotRow] = Rowop1(A[pivotRow], A[pivotRow][pivotRow],'D');
            for (j = pivotRow + 1; j < rows - 1; j++) { // Doing row operations below the pivotal element - Column wise
                A[j] = Rowop1(A[j], A[pivotRow][j],'D');
                A[j] = Rowop2(A[pivotRow], A[j], 'S');
            }
        }
        return A;
    }

//    public static void main(String[] args) {
//        double[][] C, A;
//        A = new double[][]{{5.0, 7.0, 3.0}, {7.0, 4.1, 9.8}, {7.2, 6.7, 6.1}};
//        HO ob = new HO();
//        C = new HO().UpperTriangularMatr(A);
//        for (int i = 0; i < A[0].length; i++) {
//            for (int j = 0; j < A.length; j++) {
//                System.out.print(C[i][j] + "  ");
//            }
//            System.out.println("");
//            System.out.println();
//        }
//    }
}
