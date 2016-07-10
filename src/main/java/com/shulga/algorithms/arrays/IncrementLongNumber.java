package com.shulga.algorithms.arrays;

/**
 * Created by eshulga on 7/7/16.
 */
public class IncrementLongNumber {

    public static void main(String[] args) {
        int[] num = {1, 9, 9, 9};
        new IncrementLongNumber().run(num);
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }

    private void run(int[] num) {
        for (int i = num.length - 1; i >= 0; i--) {
            int newNum = num[i] + 1;
            if (newNum < 10) {
                num[i] = newNum;
                break;
            }
            num[i] = 0;
        }
    }
}
