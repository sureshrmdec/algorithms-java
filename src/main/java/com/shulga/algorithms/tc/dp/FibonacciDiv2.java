package com.shulga.algorithms.tc.dp;

/**
 * Created by eugene on 9/26/15.
 */
public class FibonacciDiv2 {
    int find(int N){
        int first = 1;
        int second = 2;
        while(second<N){
            int firstOrig = first;
            first = second;
            second = firstOrig+second;
        }
        return Math.min(N-first,second-N);
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciDiv2().find(1000000));
    }
}
