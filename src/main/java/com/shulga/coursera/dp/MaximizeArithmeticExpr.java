package com.shulga.coursera.dp;

/**
 * Created by eugene on 3/25/16.
 */
public class MaximizeArithmeticExpr {
    public static void main(String[] args) {
        System.out.println(new MaximizeArithmeticExpr().run(new int[]{1,2,3,4,5},4));
    }

    private int run(int[] nums,int c) {
        if(c==0){
            return 0;
        }
        return -1;
    }

    int max(int i1,int i2,int i3){
        int tempMax = Math.max(i1,i2);
        return Math.max(tempMax,i3);
    }
}
