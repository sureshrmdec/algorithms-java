package com.shulga.algorithms.cf.practice;

/**
 * Created by eshulga on 10/23/15.
 */
public class DuffAndMeat {
    public int getMinPrice(int n,int[] a,int[] p){
        int minPrice = Integer.MAX_VALUE;
        int totalPrice = 0;
        for (int i = 0; i <n; i++) {
            minPrice = Math.min(minPrice,p[i]);
            totalPrice += minPrice*a[i];
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        System.out.println(new DuffAndMeat().getMinPrice(3,new int[]{1,2,3},new int[]{3,1,2}));
    }
}
