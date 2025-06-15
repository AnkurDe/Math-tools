package Calculus;

import FunctionDefinations.ScalarOutput.FunctionMultipleVariable;

public class MVC {
    public static double stepSize = 0.000001;
    public static double tolerance = 0.000001;

    public static final double pi = 3.14159265358979323846;
    public static final double e = 2.718281828459045;

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
