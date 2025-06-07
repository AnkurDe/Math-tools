package Matrix;

//import static Matrix.PrintMatrix.printMat;
import static Vector.Dot.dot;
import static Vector.Normalize.normalise;
import static Vector.Scale.scale;
import static Vector.Subtraction.subtract;

public class GramSchmidtOrthogonalization {
        // Main method: Gram-Schmidt Orthonormalization
    public static double[][] GSO(double[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        double[][] Q = new double[rows][cols];

    public static double[][] GSO(double[][] matrix){
        return transpose(GSOt(matrix));
    }

    protected static double[][] GSOt(double[][] matrix) {
        if (matrix[0].length == 1) {
            return matrix.clone();
        }

        double[][] orig = transpose(matrix);
        double[][] ortho = new double[orig.length][orig[0].length];

        // There are orig.length number of vectors
        for (int i = 0; i < orig.length; i++) {
            double[] vec = orig[i];

//    public static void main(String[] args) {
//        // Test 1: Standard basis (should return the same matrix)
//        System.out.println("case 1");
//        double[][] A = {
//                {1,0,0},
//                {0,1,0},
//                {0,0,1}
//        };
//        printMat(GSO(A)); // Expected: [[1,0,0],[0,1,0],[0,0,1]]
//
//// Test 2: Two linearly independent vectors
//        System.out.println("case 2");
//        double[][] B = {
//                {1,1},
//                {1,0},
//                {0,1}
//        };
//        printMat(GSO(B));
//// Expected: First column unchanged, second column orthogonalized
//// [[1, 1], [1, -0.5], [0, 0.5]]
//
//// Test 3: Two linearly dependent vectors
//        System.out.println("case 3");
//        double[][] C = {
//                {1,2},
//                {2,4},
//                {3,6}
//        };
//        printMat(GSO(C));
//// Expected: Second column becomes zero vector
//// [[1,0],[2,0],[3,0]]
//
//// Test 4: Single vector
//        System.out.println("case 4");
//        double[][] D = {
//                {3},
//                {4},
//                {0}
//        };
//        printMat(GSO(D));
//// Expected: Same as input
//// [[3],[4],[0]]
//
//// Test 5: Zero vector and a nonzero vector
//        System.out.println("case 5");
//        double[][] E = {
//                {0,1},
//                {0,0},
//                {0,0}
//        };
//        printMat(GSO(E));
//// Expected: [[0,1],[0,0],[0,0]]
//    }
}
