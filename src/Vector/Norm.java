package Vector;

import static Vector.Dot.dot;
import static java.lang.Math.sqrt;

public class Norm {
    public static double norm(double[] vector){
        return sqrt(dot(vector,vector));
    }
}
