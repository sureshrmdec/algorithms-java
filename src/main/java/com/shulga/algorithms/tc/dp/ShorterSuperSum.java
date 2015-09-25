package com.shulga.algorithms.tc.dp;

/**
 * Created by eshulga on 9/25/15.
 * <p>
 * <p>
 * SuperSum(0 , n) = n, for all positive n.
 * SuperSum(k , n) = SuperSum(k-1 , 1) + SuperSum(k-1 , 2) + ... + SuperSum(k-1 , n), for all positive k, n.
 */
public class ShorterSuperSum {

    int calculate(int k, int n) {
        int res = 0;
        return calcReq(k-1, n, res);
    }

    int calcReq(int k, int n, int res) {
        if (k == 0) {
            return sum(n);
        }
        for (int i = 1; i <= n; i++) {
            res+=calcReq(k-1,i,res);
        }
        return res;
    }

    private int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ShorterSuperSum().calculate(4, 10));
    }
}
