package com.shulga.tc.srm;

/**
 * Created by eshulga on 9/22/15.
 */
public class DevuAndGame {

    String canWin(int[] nextLevel) {
        int count = 0;
        int position = 0;
        while (count < nextLevel.length) {
            position = nextLevel[position];
            if (position == -1) {
                return "Win";
            }
            count++;
        }
        return "Lose";
    }

    public static void main(String[] args) {
        System.out.println(new DevuAndGame().canWin(new int[]{3, 1, 1, 2, -1, 4}));
    }
}
