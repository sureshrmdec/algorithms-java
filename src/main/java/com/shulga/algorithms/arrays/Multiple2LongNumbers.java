package com.shulga.algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by eshulga on 6/23/16.
 */
public class Multiple2LongNumbers {
    public static void main(String[] args) {
        int[] run = new Multiple2LongNumbers().run(new int[]{1, 2}, new int[]{5, 6});
        for (int i = 0; i < run.length; i++) {
            System.out.print(run[i]);
        }
    }

    private int[] run(int[] num1, int[] num2) {
        boolean isNegative = (num1[0] < 0 && num2[0] > 0) || (num1[0] < 0 && num2[0] > 0) ? true : false;
        int[] res = new int[num1.length+num2.length+1];
        Collections.reverse(Arrays.asList(num1));
        Collections.reverse(Arrays.asList(num2));
        num1[0]= Math.abs(num1[0]);
        num2[0]=Math.abs(num2[0]);
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                int multiple = num1[i]*num2[j];
                res[i+j] = res[i+j] + multiple;
                res[i+j+1] = res[i+j+1] + res[i+j]/10;
                res[i+j] = res[i+j]%10;
            }
        }
        int end = res.length;
        int lastElem = res[end-1];
        while(lastElem==0){
            end--;
            lastElem = res[end];
        }

        int start = 0;
        while(start<end){
            int temp = res[start];
            res[start] = res[end];
            res[end] = temp;
            start++;
            end--;
        }
        return res;
    }
}
