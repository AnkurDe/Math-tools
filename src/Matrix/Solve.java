package Matrix;

import static Matrix.Operations.inv;
import static Matrix.Operations.multiply;
import static Matrix.Operations.transpose;

// To solve a system of linear equations
final public class Solve {
    // To solve a system of linear equations Ax = B for x

    public static double[] solve(double[][] A, double[] B){
        return solve(A,transpose(new double[][]{B}));
    }

    public static double[] solve(double[][] A, double[][] B) {
        double[] result;
        // Check dimensions: A is n x n, B is n x 1
        if (A.length != A[0].length)
            throw new ArithmeticException("A must be square for solve()");
        if (B[0].length != 1)
            throw new ArithmeticException("B must be a column vector (n x 1)");
        if (A.length != B.length)
            throw new ArithmeticException("A and B must have the same number of rows");

        try {
            double[][] x = multiply(inv(A), B);
            // Flatten result to 1D array
            result = new double[x.length];
            for (int i = 0; i < x.length; i++) {
                result[i] = x[i][0];
            }
        }
        catch (DimensionErrorException _){
            throw new ArithmeticException("Incorrect sizes of matrices for given equations\nFor linear regression use pseudoinverse");
        }
        catch (MatrixError e){
            throw new ArithmeticException("Must be linearly independent");
        }
        return result;
    }
}
