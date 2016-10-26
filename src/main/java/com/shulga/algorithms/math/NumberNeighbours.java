package com.shulga.algorithms.math;

import java.util.Arrays;

/**
 * Created by eshulga on 10/7/15.
 */
public class NumberNeighbours {
    int numPairs(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                char[] num1 = String.valueOf(numbers[i]).toCharArray();
                char[] num2 = String.valueOf(numbers[j]).toCharArray();
                Arrays.sort(num1);
                Arrays.sort(num2);
                if(Integer.parseInt(new String(num1))==Integer.parseInt(new String(num2))){
                    count++;
                }
            }
        }
        return count;

    }


    public static void main(String[] args) {
        System.out.println(new NumberNeighbours().numPairs(new int[]{1, 10, 100, 1000, 10000, 100000, 1000000}));
    }
}
