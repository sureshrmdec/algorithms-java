package com.shulga.algorithms;

/**
 * Created by eugene on 2/7/16.
 */
public class PrintGivenMatrixinSpiralForm {

    public static void main(String[] args) {
        int[][] ar = new int[][]{{1,2,3,4},{5,6,7,8},
                {9,10,11,12},{13,14,15,16}};
        int[] res = new PrintGivenMatrixinSpiralForm().run(ar);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] run(int[][] A) {
        return A[1];
    }
}
