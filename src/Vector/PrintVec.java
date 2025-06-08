package Vector;

public class PrintVec {
    public static void printVec(double[] v) {
        for (double d : v) {
            System.out.printf("%.2f ", d);
        }
        System.out.println();
    }
}
