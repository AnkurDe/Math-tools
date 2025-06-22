package Matrix.TestCases;

import static Matrix.Decomposition.svd;
import static Matrix.Operations.multiply;
import static Matrix.Operations.printMat;

public class SVD {
    public static void main(String[] args) {
        double[][][] testMatrices = {
            {
                {1, 0},
                {0, 1}
            },
            {
                {3, 1},
                {1, 3}
            },
            {
                {1, 2, 3},
                {4, 5, 6}
            },
            {
                {2, 4},
                {1, 3},
                {0, 0}
            }
        };
        String[] testNames = {
            "Test 1: 2x2 Identity Matrix",
            "Test 2: 2x2 Symmetric Matrix",
            "Test 3: 2x3 Rectangular Matrix",
            "Test 4: 3x2 Rectangular Matrix with Zero Row"
        };

        for (int i = 0; i < testMatrices.length; i++) {
            System.out.println(testNames[i]);
            double[][] A = testMatrices[i];
            System.out.println("Input Matrix A:");
            printMat(A);

            double[][][] svdResult = svd(A);
            double[][] U = svdResult[0];
            double[][] S = svdResult[1];
            double[][] Vt = svdResult[2];

            System.out.println("U:");
            printMat(U);
            System.out.println("Sigma:");
            printMat(S);
            System.out.println("V^T:");
            printMat(Vt);

            // Reconstruct A = U * S * V^T
            double[][] US = multiply(U, S);
            double[][] USVt = multiply(US, Vt);
            System.out.println("Reconstructed A (U * Sigma * V^T):");
            printMat(USVt);

            System.out.println("=====================================");
        }
    }
}
