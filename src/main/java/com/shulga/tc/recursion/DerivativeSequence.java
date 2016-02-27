package com.shulga.tc.recursion;

/**
 * Created by eshulga on 10/5/15.
 */
public class DerivativeSequence {
    int[] derSeq(int[] a, int n){
        if(n==0){
            return a;
        }
        int[] newAr = new int[a.length-1];
        for (int i = 1; i < a.length; i++) {
            newAr[i-1] = a[i]-a[i-1];
        }
        return derSeq(newAr,n-1);
    }


    public static void main(String[] args) {
        int[] ints = new DerivativeSequence().derSeq(new int[]{-100,100}, 0);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}
