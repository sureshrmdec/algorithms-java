package com.shulga.tc.math;

/**
 * Created by eshulga on 10/6/15.
 */
public class BishopMove {

    int howManyMoves(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return 0;
        }
        if ((r1 + c1) % 2 != (r2 + c2) % 2) {
            return -1;
        }
        if (Math.abs(r1 - r2) == Math.abs(c1 - c2)) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(new BishopMove().howManyMoves(4, 6, 7, 3));
    }
}
