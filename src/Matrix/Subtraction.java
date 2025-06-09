package Matrix;

//import static Matrix.PrintMatrix.printMat;

// For performing subtraction
final public class Subtraction {
    public static double[][] sub(double[][] A, double[][] B) {

        if (A.length != B.length) {
            throw new MatrixCorruptException("Mismatch in number of rows of matrices");
        }
        if (A[0].length != B[0].length){
            throw new MatrixCorruptException("Mismatch in number of columns of matrices");
        }

        double[][] Subtract = new double[A.length][A.length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A.length; j++)
                Subtract[i][j] = (A[i][j] - B[i][j]);
        return Subtract;
    }//Tested ok

//    public static void main(String[] args) {
//        // Test 1: Correct addition
//        double[][] A = {
//                {1, 2},
//                {3, 4}
//        };
//        double[][] B = {
//                {5, 6},
//                {7, 8}
//        };
//        System.out.println("Test 1: Correct addition");
//        double[][] sum = sub(A, B);
//        printMat(sum);
//        // Expected:
//        // 6.0 8.0
//        // 10.0 12.0
//
//        // Test 2: Mismatched rows
//        double[][] C = {
//                {1, 2}
//        };
//        try {
//            System.out.println("Test 2: Mismatched rows");
//            sub(A, C);
//        } catch (Exception e) {
//            System.out.println("Caught exception: " + e.getMessage());
//            // Expected: Mismatch in number of rows of matrices
//        }
//
//        // Test 3: Mismatched columns
//        double[][] D = {
//                {1, 2, 3},
//                {4, 5, 6}
//        };
//        try {
//            System.out.println("Test 3: Mismatched columns");
//            sub(A, D);
//        } catch (Exception e) {
//            System.out.println("Caught exception: " + e.getMessage());
//            // Expected: Mismatch in number of columns of matrices
//        }
//    }
}
