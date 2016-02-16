package com.shulga.arrays;

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
public class PrintMAtrixInSpiralOrder {
    public static void main(String[] args) {
        List<Integer> run = new PrintMAtrixInSpiralOrder().run(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        for (Integer num : run) {
            System.out.print(num + " ");
        }
    }

    private List<Integer> run(int[][] A) {
        int is = 0;
        int js = 0;
        int ie = A.length;
        int je = A[0].length;
        List<Integer> list = new ArrayList<>();
        while (is < ie && js < je) {
            for (int k = js; k < je; k++) {
                list.add(A[is][k]);
            }
            for (int k = is + 1; k < ie; k++) {
                list.add(A[k][je - 1]);
            }
            for (int k = je - 2; k > js; k--) {
                list.add(A[ie - 1][k]);
            }
            for (int k = ie - 1; k > is; k--) {
                list.add(A[k][js]);
            }
            is++;
            js++;
            je--;
            ie--;
        }
        return list;
    }
}
