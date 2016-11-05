package com.shulga.algorithms.matrix;

/**
 * Created by eshulga on 10/28/16.
 */
public class BinarySearchMatrix {

    public static void main(String[] args) {
        int[][] m = new int[3][5];
        m[0] = new int[]{1, 2, 4, 6, 7};
        m[1] = new int[]{8, 10, 11, 14, 15};
        m[2] = new int[]{16, 17, 20, 30, 40};
        System.out.println(new BinarySearchMatrix().run(m, 0));
        System.out.println(new BinarySearchMatrix().run(m, 1));
        System.out.println(new BinarySearchMatrix().run(m, 100));
        System.out.println(new BinarySearchMatrix().run(m, 17));
    }

    private int run(int[][] m, int k) {
        int l = 0;
        int len = m.length;
        int r = m.length * m[0].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / len;
            int col = mid % len;
            if(row>=len) break;
            if (m[row][col] == k) {
                return m[row][col];
            } else if (m[row][col] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
