package Vector;

import static java.util.Arrays.setAll;

public class Scale {
    public static double[] scale(double[] vector, double scalingFactor){
        return Arrays.stream(vector).map(v -> v * scalingFactor).toArray().clone();
//        setAll(vector, i -> vector[i] * scalingFactor);
//        return vector;
    }

    // Test cases for scale function
    public static void main(String[] args) {
        // Test 1: Scale by 2
        double[] v1 = {1, 2, 3};
        double[] r1 = scale(v1.clone(), 2);
        System.out.print("Test 1: ");
        printVec(r1);

        // Test 2: Scale by 0
        double[] v2 = {4, -5, 6};
        double[] r2 = scale(v2.clone(), 0);
        System.out.print("Test 2: ");
        printVec(r2);

        // Test 3: Scale by -1
        double[] v3 = {7, 8, 9};
        double[] r3 = scale(v3.clone(), -1);
        System.out.print("Test 3: ");
        printVec(r3);

        // Test 4: Scale empty vector
        double[] v4 = {};
        double[] r4 = scale(v4.clone(), 5);
        System.out.print("Test 4: ");
        printVec(r4);

        // Test 5: Scale by 0.5
        double[] v5 = {2, 4, 6};
        double[] r5 = scale(v5.clone(), 0.5);
        System.out.print("Test 5: ");
        printVec(r5);
    }
}
