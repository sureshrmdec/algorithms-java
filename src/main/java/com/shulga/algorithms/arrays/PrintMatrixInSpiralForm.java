package com.shulga.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 Print a given matrix in spiral form
 Given a 2D array, print it in spiral form. See the following examples.

 Input:
 1    2   3   4
 5    6   7   8
 9   10  11  12
 13  14  15  16
 Output:
 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10


 Input:
 1   2   3   4  5   6
 7   8   9  10  11  12
 13  14  15 16  17  18
 Output:
 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 */
public class PrintMatrixInSpiralForm {
    public static void main(String[] args) {
        new PrintMatrixInSpiralForm().run(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }

    private void run(int[][] A) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length / 2; i++) {
        traverse(A, A.length,i,i, list);
        }
        for (Integer num:list){
            System.out.print(num+" ");
        }
    }

    private void traverse(int[][] A, int N, int i, int j,List list) {
            for (int k = 0; k < N-1; k++) {
                list.add(A[i][j+k]);
            }
        for (int k = 0  ; k < N-2; k++) {
            list.add(A[N-1+k][N-1]);
        }
        for (int k = N-2  ; k>0; k--) {
            list.add(A[N-1][k]);
        }
        for (int k = N-2  ; k>1; k--) {
            list.add(A[N-1][k]);
        }
    }
}
