package com.shulga.interview.arrays;

/**
 * If an element in an MxN matrix is 0, its entire row and column is set to 0
 * <p/>
 * Created by ievgen on 10/9/2014.
 */
public class PlayMatrix {

    public static void process(int[][] matrix) {
        int rowLength = matrix[0].length;
        int columnLength = matrix.length;
        int[] rows = new int[rowLength];
        int[] columns = new int[columnLength];
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (matrix[i][j] == 0) {
                    rows[j] = 1;
                    columns[i] = 1;
                }
            }
        }
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (rows[j] == 1 || columns[i] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 0, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        printMatrix(matrix);
        process(matrix);
        System.out.println();
        printMatrix(matrix);
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
}
