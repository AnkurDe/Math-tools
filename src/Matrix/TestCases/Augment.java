package Matrix.TestCases;

import Matrix.Operations;

import static Matrix.Operations.aug;
import static Matrix.Operations.printMat;

public final class Augment {
    public static void main(String[] args) {
        // Test case 1: Row-wise augmentation (A|B)
        double[][] A1 = {
            {1, 2},
            {3, 4}
        };
        double[][] B1 = {
            {5, 6},
            {7, 8}
        };
        System.out.println("A1:");
        printMat(A1);
        System.out.println("B1:");
        printMat(B1);
        System.out.println("Row-wise Augmentation (A1|B1):");
        printMat(aug(A1, B1, 'r'));

        // Test case 2: Column-wise augmentation
        double[][] A2 = {
            {1, 2},
            {3, 4}
        };
        double[][] B2 = {
            {5, 6}
        };
        System.out.println("\nA2:");
        printMat(A2);
        System.out.println("B2:");
        printMat(B2);
        System.out.println("Column-wise Augmentation:");
        printMat(aug(A2, B2, 'c'));

        // Test case 3: Mismatched rows for row-wise augmentation (should throw error)
        double[][] A3 = {
            {1, 2}
        };
        double[][] B3 = {
            {3, 4},
            {5, 6}
        };
        try {
            System.out.println("\nAttempting row-wise augmentation with mismatched rows:");
            printMat(aug(A3, B3, 'r'));
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // Test case 4: Mismatched columns for column-wise augmentation (should throw error)
        double[][] A4 = {
            {1, 2},
            {3, 4}
        };
        double[][] B4 = {
            {5, 6, 7}
        };
        try {
            System.out.println("\nAttempting column-wise augmentation with mismatched columns:");
            printMat(aug(A4, B4, 'c'));
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
