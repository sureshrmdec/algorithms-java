package com.shulga.tc.dp;

/**
 * Created by eshulga on 9/25/15.
 * <p>
 * <p>
 * SuperSum(0 , n) = n, for all positive n.
 * SuperSum(k , n) = SuperSum(k-1 , 1) + SuperSum(k-1 , 2) + ... + SuperSum(k-1 , n), for all positive k, n.
 */
public class ShorterSuperSum {

    int calculate(int k, int n) {
        int sum=0;
        if(k==0) {
            return n;
        }
        for (int i = 1; i <= n; i++) {
            sum+=calculate(k-1,i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ShorterSuperSum().calculate(4,10));
    }
}
