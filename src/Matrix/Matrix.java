package Matrix;

/*
* MAYBE MARKED FOR DELETION
* */

public class Matrix {
    // Addition
    public static double[][] add(double[][] A, double[][] B) {
        return Addition.Add(A, B);
    }

    public static boolean checkAddition(double[][] A, double[][] B) {
        return Comply.compla(A, B);
    }

    public static void printMat(double[][] A) {
        PrintMatrix.printMat(A);
    }

    // Determinant
//    public static double determinant(double[][] A) {
//        return Determinant.det(A);
//    }

    // Diagonal Product
//    public static double diagonalProduct(double[][] A) {
//        return DiagonalProduct.diagProduct(A);
//    }

    // Gaussian Elimination
//    public static double[][] gaussianElimination(double[][] A) {
//        return GaussianElimination.gauss(A);
//    }

    // Identity Matrix
//    public static double[][] identity(int size) {
//        return Identity.identity(size);
//    }

    // Matrix Inverse
//    public static double[][] inverse(double[][] A) {
//        return Inverse.inverse(A);
//    }

    // Corruption Check
    public static boolean isCorrupt(double[][] A) {
        return IsCorrupt.isCorrupt(A);
    }

    // Square Matrix Check
    public static boolean isSquare(double[][] A) {
        return IsSquare.isSquare(A);
    }

    // LU Decomposition
    public static double[][][] lu(double[][] A) {
        return LUDecomposition.lu(A);
    }

    // Multiplication
    public static double[][] multiply(double[][] A, double[][] B) {
        return Multiplication.multiply(A, B);
    }

    // Matrix Printing
    public static void print(double[][] A) {
        PrintMatrix.printMat(A);
    }

    // RREF (Reduced Row Echelon Form)
    public static double[][] rref(double[][] A) {
        return RREF.rref(A);
    }

    // System Solver
//    public static double[] solve(double[][] A, double[] b) {
//        return Solve.solve(A, b);
//    }

    // Subtraction
//    public static double[][] subtract(double[][] A, double[][] B) {
//        return Subtraction.Sub(A, B);
//    }

    // Sum of Elements
    public static double sum(double[][] A) {
        return SumOfElements.sum(A);
    }

    // SVD (Singular Value Decomposition)
//    public static double[][][] svd(double[][] A) {
//        return SVD.svd(A);
//    }

    // Transpose
    public static double[][] transpose(double[][] A) {
        return Transpose.transpose(A);
    }

    // Zero Matrix
    public static double[][] zeros(int rows, int cols) {
        return ZeroMatrix.zeros(rows, cols);
    }

    public static double[][] zeros(double[][] A) {
        return ZeroMatrix.zeros(A);
    }
    public static double[][] zeros(int rows, int cols, double[][] A) {
        return ZeroMatrix.zeros(rows, cols);
    }
}