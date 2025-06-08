package Calculus;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class SVC {
    // Method to perform Runge-Kutta method order 4
    public static double stepSize = 0.000001;
    public static double tolerance = 0.000001;

    public static final double pi = 3.14159265358979323846;
    public static final double e = 2.718281828459045;

    // COMPLETE
    // This is for a single variable function
    // t0 is initial time
    // y0 is initial value
    // t is final time
    // fn is the function to be solved
    public final static double RK4(double t0, double y0, double t, Function fn) {
        double y = y0;
        while (t0 < t) {
            double k1 = fn.function(t0, y);
            double k2 = fn.function(t0 + stepSize / 2.0, y + k1 / 2.0);
            double k3 = fn.function(t0 + stepSize / 2.0, y + k2 / 2.0);
            double k4 = fn.function(t0 + stepSize, y + k3);
            double delta_y = (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            y = y0 + stepSize * delta_y;
            t0 += stepSize;
        }
        return y;
    }

    // COMPLETE
    // t0 is initial time
    // y0 is initial value
    // t is final time
    // fn is the function to be solved
    public final static double RK5(double t0, double y0, double t, Function fn) {
        double step = stepSize;
        int n = (int) ((t - t0) / step);

        double y = y0;

        for (double i = 0; i < n; i++) {
            double k1 = fn.function(t0, y);

            double t0Dot5 = t0 + step * 0.5;
            double y1 = y + step * k1 * 0.5;
            double k2 = fn.function(t0Dot5, y1);

            double t0Plus = t0 + step;
            double y2 = y + step * (k1 + k2) * 0.5;
            double k3 = fn.function(t0Plus, y2);

            double tMid = t0 + step * 0.25;
            double y3 = y + step * (k1 + 2 * k2) * 0.25;
            double k4 = fn.function(tMid, y3);

            double tMidDot = t0 + step * 0.75;
            double y4 = y + step * (-k1 + 3 * k2 + 4 * k3) * 0.5;
            double k5 = fn.function(tMidDot, y4);

            y += step * (-k1 + 8 * k3 + 6 * k4 + 8 * k5) / 12;

            t0 = t0Plus;
        }

        return y;
    }

    // INCOMPLETE
    // Uses either of RK4 or RK5 method based on accuracy difference
    public final static double ode45(double t0, double y0, double t, Function fn) {
        // Measure error and calculate tolerance

        // Use RK4 and RK5 error is less than tolerance
        if (abs(RK4(t0, y0, t0 + stepSize, fn) - RK5(t0, y0, t0 + stepSize, fn)) <= tolerance) {
            // Use RK4 - Computationally less expensive
            return RK4(t0, y0, t, fn);
        } else {
            // Use RK5 - Computationally more expensive but more accurate
            return RK5(t0, y0, t, fn);
        }
    }

    // COMPLETE
    public final static double differentiate(final double val, Function fn) {
        return (fn.function(val + stepSize) - fn.function(val - stepSize)) / (2.0 * stepSize);
    }


    // COMPLETE
    double differentiate(double val, int order, Function fn) {
        if (order <= 0) {
            throw new IllegalArgumentException("The order is less than or equal to 0");
        } else if (order == 1) {
        final double a = differentiate(val, fn);
            if (abs(a) <= tolerance) {
                return 0;
            }
            return a;
        } else if (order == 2) {
            double a = (fn.function(val + stepSize) - 2 * fn.function(val) + fn.function(val - stepSize)) / (stepSize * stepSize);
            if (abs(a) <= tolerance) {
                return 0;
            }
            return a;
        } else {
            double a = differentiate(val + stepSize, --order, fn) - differentiate(val - stepSize, --order, fn) / (2 * stepSize);
            if (abs(a) <= tolerance) {
                return 0;
            }
            return a;
        }
    }

    // INCOMPLETE
    double df(final double valX, final double valY, final double step, Function fn) {
        return (fn.function(valX - step, valY) + fn.function(valX, valY - step)) * (step * 2.0);
    }

    double integrate(final double start, final double end, Function fn) {

        double ar = 0.0, x1 = start, x2 = start + stepSize;
        while (x2 < end) {
            x2 = min(x1 + stepSize, end); // Ensure x2 does not exceed the end
            // Declaring and finding area
            double f1 = fn.function(x1);
            double f2 = fn.function(x2);
            ar += (x2 - x1) * ((fn.function(x1) + fn.function(x2)) / 2.0);

            //Increment
            x1 = x2;
        }
        return ar;
    }

    int factorial(final int num) {
        if (num<0) throw new IllegalArgumentException("The number is less than 0");
        if (num > 20) throw new IllegalArgumentException("The number can cause overflow");

        if (num == 0 || num == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 2; i <= num; i++) {
            result = result * i;
        }
        return result;
    }

    /*

// INCOMPLETE
    double*

    Taylor(double val, int order, double (*function)(double))

    {
        //
        double *tlr;
        tlr = ( double*)malloc(order * sizeof( double));
        return NULL;
    }


    // INCOMPLETE
    void print_taylor(double val, int order, double (*function)(double)) {
        //
        for (int i = 0; i < order; i++) {
            std::cout << "((x^" << i << ")/" << differentiate(val, i, function) / factorial(i) << ")" << std::endl;
        }

    }


    // INCOMPLETE
    double Taylor_eval() {
        return 0;
    }


// INCOMPLETE
    double*

    McLaurin() {
        //
        return nullptr;
    }

*/
}
