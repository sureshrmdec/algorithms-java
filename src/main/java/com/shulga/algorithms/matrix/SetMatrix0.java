package com.shulga.algorithms.matrix;

/**
 * Created by eshulga on 10/26/16.
 * <p>
 * 1 2 3 4
 * 0 2 1 2
 * 1 3 0 0
 * 1 2 3 4
 *
 * 0 2 3 4
 * 0 2 1 2
 * 0 3 0 0
 * 0 2 3 4
 */
public class SetMatrix0 {
    public static void main(String[] args) {
        int[][] m = new int[4][4];
        m[0] = new int[]{1, 2, 3, 4};
        m[1] = new int[]{0, 2, 1, 2};
        m[2] = new int[]{1, 3, 0, 0};
        m[3] = new int[]{1, 2, 3, 4};
        new SetMatrix0().run(m);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void run(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if(m[i][j]==0){
                    for (int k = 0; k < m.length; k++) {
                        m[i][k] = 0;
                    }
                    for (int k = 0; k < m[j].length; k++) {
                        m[k][j] = 0;
                    }
                }
            }
        }
    }
}
