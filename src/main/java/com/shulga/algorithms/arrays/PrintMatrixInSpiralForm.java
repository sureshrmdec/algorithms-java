package com.shulga.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Print a given matrix in spiral form
 * Given a 2D array, print it in spiral form. See the following examples.
 * <p>
 * Input:
 * 1    2   3   4
 * 5    6   7   8
 * 9   10  11  12
 * 13  14  15  16
 * Output:
 * 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * <p>
 * <p>
 * Input:
 * 1   2   3   4  5   6
 * 7   8   9  10  11  12
 * 13  14  15 16  17  18
 * Output:
 * 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 */
public class PrintMatrixInSpiralForm {
    public static void main(String[] args) {
        new PrintMatrixInSpiralForm().run(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }

    private void run(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            traverse(matrix,i);
        }
    }

    private void traverse(int[][] matrix, int offset) {
        for (int i = offset; i < matrix[offset].length-offset-1; i++) {
            System.out.println(matrix[offset][i]);
        }
        for (int i = offset; i <matrix.length-offset-1; i++) {
            System.out.println(matrix[i][matrix.length-1-offset]);
        }
        for (int i = matrix.length-offset-1; i >offset; i--) {
            System.out.println(matrix[matrix.length-1-offset][i]);
        }
        for (int i = matrix.length-offset-1; i >offset; i--) {
            System.out.println(matrix[i][offset]);
        }
    }


}
