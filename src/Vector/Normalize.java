package Vector;

import static Vector.Dot.Norm.norm;
import static Vector.Scale.scale;

public class Normalize {
    public static double[] normalise(double[] vector){
        double norm = norm(vector);
        if (norm == 0.0){
            return vector.clone();
        }
        return scale(vector, 1.0/norm);
    }
}
