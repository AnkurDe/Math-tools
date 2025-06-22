package Calculus;

import FunctionDefinations.ScalarOutput.FunctionMultipleVariable;

/**
 * MVC (Multi Variable Calculus) provides static methods for numerical calculus operations
 * on functions of several variables, including gradient, Hessian, and mixed partial derivatives.
 *
 * <p>
 * Features:
 * <ul>
 *   <li>Numerical gradient (vector of partial derivatives)</li>
 *   <li>Numerical Hessian (matrix of second derivatives)</li>
 *   <li>Mixed partial derivatives (cross derivatives)</li>
 * </ul>
 * </p>
 */
public class MVC {
    /** Step size for numerical methods */
    public static double stepSize = 0.000001;
    /** Tolerance for zero detection */
    public static double tolerance = 0.000001;

    /** Mathematical constant pi */
    public static final double pi = 3.14159265358979323846;
    /** Mathematical constant e */
    public static final double e = 2.718281828459045;

    /**
     * Computes the gradient vector of a multivariable function at a given point.
     * Uses a central difference for each variable.
     * @param fn Function f(x1, x2, ..., xn)
     * @param x Point at which to compute the gradient
     * @return Gradient vector (partial derivatives with respect to each variable)
     * @throws RuntimeException if the function dimension and input dimension do not match
     */
    public static double[] grad(FunctionMultipleVariable fn, double... x) {
        int n = x.length;
        double[] grad = new double[n];
        try {
            for (int i = 0; i < n; i++) {
                double[] arrLeft = x.clone(), arrRight = x.clone();
                arrLeft[i] = arrLeft[i] + stepSize;
                arrRight[i] = arrRight[i] - stepSize;
                grad[i] = (fn.function(arrLeft) - fn.function(arrRight)) / (2.0 * stepSize);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new RuntimeException("Function dimension and given dimension to evaluate are not same");
        }
        return grad;
    }

    /**
     * Computes the second partial derivative with respect to two variables.
     * Uses central difference for mixed partials and standard second difference for pure partials.
     * @param fn Function f(x1, x2, ..., xn)
     * @param var1 Index of the first variable (0-based)
     * @param var2 Index of the second variable (0-based)
     * @param x Point at which to compute the derivative
     * @return Approximate value of d^2f/dx_var1 dx_var2 at x
     */
    public static double d2f_dx1dx2(final FunctionMultipleVariable fn, final int var1, final int var2, final double... x) {
        if (var1 == var2) {
            double[] t = x.clone();

            t[var1] = t[var1] + stepSize;
            double a = fn.function(t);

            double b = fn.function(x);

            t = x.clone();
            t[var1] = t[var1] - stepSize;
            double c = fn.function(t);

            return (a - 2.0*b + c) / (stepSize * stepSize);
        }

        double[] t = x.clone();
        t[var1] = t[var1] + stepSize;
        t[var2] = t[var2] + stepSize;
        double a = fn.function(t);

        t = x.clone();
        t[var1] = t[var1] + stepSize;
        t[var2] = t[var2] - stepSize;
        double b = fn.function(t);

        t = x.clone();
        t[var1] = t[var1] - stepSize;
        t[var2] = t[var2] + stepSize;
        double c = fn.function(t);

        t = x.clone();
        t[var1] = t[var1] - stepSize;
        t[var2] = t[var2] - stepSize;
        double d = fn.function(t);

        return (a - b - c + d) / (4.0 * stepSize * stepSize);
    }

    /**
     * Computes the Hessian matrix (matrix of all second partial derivatives) at a given point.
     * The Hessian is symmetric for functions with continuous second derivatives.
     * @param fn Function f(x1, x2, ..., xn)
     * @param x Point at which to compute the Hessian
     * @return Hessian matrix (n x n)
     */
    public static double[][] hessian(FunctionMultipleVariable fn, double... x) {
        double[][] hess = new double[x.length][x.length];

        for (int i = 0; i < x.length; i++) {
            for (int j = i; j < x.length; j++) {
                double a = d2f_dx1dx2(fn, i, j, x);
                hess[i][j] = a;
                hess[j][i] = a;
            }
        }

        return hess;
    }
}
