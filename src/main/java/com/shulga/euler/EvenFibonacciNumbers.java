package com.shulga.euler;

/**
 * Created by eshulga on 10/26/15.
 */
public class EvenFibonacciNumbers {

    long sumFibMunbers(int limit){
        int first = 1;
        int second = 1;
        long sum = 0;
        while(second<=limit){
            int temp = second;
            second = first+second;
            first = temp;
            if(second%2==0){
                sum+=second;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new EvenFibonacciNumbers().sumFibMunbers(4000000));
    }
}
