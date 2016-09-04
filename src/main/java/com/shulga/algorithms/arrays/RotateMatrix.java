package com.shulga.algorithms.arrays;

/**
 * Created by ievgen on 10/9/2014.
 */
public class RotateMatrix {


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        printMatrix(matrix);
        rotate(matrix, 4);
        System.out.println();
        printMatrix(matrix);
    }

    // rotate matrix 90 degrees
    private static void rotate(int[][] matrix, int width) {
        for (int layer = 0; layer < width / 2; layer++) {
            int first = layer;
            int last = width - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; //save top left
                //buttom left to top left
                matrix[first][i] = matrix[last - offset][first];
                //right to left (bottom)
                matrix[last - offset][first] = matrix[last][last - offset];
                //right top to right buttom
                matrix[last][last - offset] = matrix[i][last];
                //top to right top
                matrix[i][last] = top;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[1].length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[1].length; j++) {
                int item = matrix[i][j];
                String space = item < 10 ? "   " : "  ";
                System.out.print(item + space);
            }
        }
    }













    // rotate matrix 90 degrees
    private static void rotate2(int[][] matrix, int width) {
        for (int offset = 0; offset < matrix.length / 2; offset++) {
            for (int j = 0; j < width; j=j/2) {
                int tmp = matrix[offset+j][offset];
                matrix[offset+j][offset+width] = matrix[matrix.length-1-width][offset];
                matrix[matrix.length-1-width][offset] = matrix[matrix.length-1-offset][matrix.length-1-width];
                matrix[matrix.length-1-offset][matrix.length-1-width] = matrix[matrix.length-offset][width];
                matrix[matrix.length-offset][width] = tmp;
            }
        }
    }
}
