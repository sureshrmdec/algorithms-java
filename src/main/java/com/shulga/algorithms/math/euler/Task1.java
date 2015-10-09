package com.shulga.algorithms.math.euler;

/**
 * Created by eshulga on 10/6/15.
 */
public class Task1 {

    int solve(int n, int m) {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if(i%n==0 &&i%m==0){
                sum+=i;
            }else if(i%n==0 ||i%m==0){
                sum+=i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Task1().solve(3, 5));
    }
}
