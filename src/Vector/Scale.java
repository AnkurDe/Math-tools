package Vector;

import static java.util.Arrays.setAll;

public class Scale {
    public static double[] scale(double[] vector, double scalingFactor){
        setAll(vector, i -> vector[i] * scalingFactor);
        return vector;
    }
}
