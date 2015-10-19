package com.shulga.algorithms.tc;

/**
 * Created by eshulga on 10/14/15.
 */
public class BearPaints {
    long maxArea(int W, int H, long M) {
        if (W * H <= M) {
            return W * H;
        }
        int max = 0;
        int min = W < H ? W : H;
        for (int i = W / min; i <= W; i++) {
            for (int j = H / min; j <= H; j++) {
                if (i * j > max && i * j <= M) {
                    max = i * j;
                }
            }
        }
        return max;
    }

    long maxArea2(int W,int H,int M){
        long ans = 0;
        for (int i = 1; i <= W; i++) {
            long x = Math.min(M/i,H);
            ans = Math.max(ans,i*x);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BearPaints().maxArea(4, 4, 10));
        System.out.println(new BearPaints().maxArea2(4, 4, 10));
    }
}
