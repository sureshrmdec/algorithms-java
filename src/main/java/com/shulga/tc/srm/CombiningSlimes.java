package com.shulga.tc.srm;

/**
 * Created by eshulga on 10/9/15.
 *
 *
 */
public class CombiningSlimes {

    int maxMascots(int[] a) {
        int sum = a[0] + a[1];
        int mascots = a[0] * a[1];
        for (int i = 2; i < a.length; i++) {
            mascots = mascots + sum * a[i];
            sum = sum + a[i];
        }
        return mascots;
    }

    public static void main(String[] args) {
        System.out.println(new CombiningSlimes().maxMascots(new int[]{7,6,5,3,4,6 }));
    }
}
