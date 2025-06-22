package Matrix.TestCases;

import static Matrix.Operations.eye;
import static Matrix.Operations.printMat;

final public class Identity {
    public static void main(String[] args) {
        // Test case 1: 3x3 identity
        System.out.println("3x3 Identity:");
        double[][] id3 = eye(3);
        printMat(id3);

        // Test case 2: 4x2 identity (rectangular)
        System.out.println("\n4x2 Identity:");
        double[][] id4x2 = eye(4, 2);
        printMat(id4x2);

        // Test case 3: 2x4 identity (rectangular)
        System.out.println("\n2x4 Identity:");
        double[][] id2x4 = eye(2, 4);
        printMat(id2x4);

        // Test case 4: Identity from matrix shape
        System.out.println("\nIdentity from matrix shape (2x3):");
        double[][] shape = {{1, 2, 3}, {4, 5, 6}};
        double[][] idShape = eye(shape);
        printMat(idShape);
    }
}