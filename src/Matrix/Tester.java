package Matrix;

import static Matrix.PrintMatrix.printMat;
import static Matrix.LUDecomposition.lu;

final public class Tester {
    public static void main(String[] args) {
        double[][] A = {{1.0, 2.0, 3.0},
                        {4.0, 5.0, 6.0},
                        {7.0, 8.0, 9.0},};
        double[][][] B= lu(A);
//        System.out.println("The determinant is "+ det(A));
        System.out.println("The lower triangular matrix");
        printMat(B[0]);
        System.out.println("The upper triangular matrix");
        printMat(B[1]);
    }
}
