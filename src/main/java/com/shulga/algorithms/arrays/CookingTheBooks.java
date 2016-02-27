package com.shulga.algorithms.arrays;

import java.util.Arrays;

/**
 * 31524
 * 897
 * 123
 * 10
 * 5
 * <p>
 * Case #1: 13524 51324
 * Case #2: 798 987
 * Case #3: 123 321
 * Case #4: 10 10
 * Case #5: 5 5
 */
public class CookingTheBooks {

    public static void main(String[] args) {
        System.out.println(find(30105904));
        System.out.println(findSwapOneNumber(97818));
    }

    private static String findSwapOneNumber(int n) {
        int[] nums = new int[9];
        int length = -1;
        while(n>0){
            int part = n%10;
            n/=10;
            nums[++length] = part;
        }
        int biggestPosition = -1;
        int biggest = -1;
        int smallestPosition = -1;
        int smallest=10;
        for (int i = length-1; i >=0; i--) {
            int current = nums[i];
            if(current >=biggest){
                biggestPosition = i;
                biggest = current;
            }
            if(current <=smallest){
                smallestPosition = i;
                smallest= current;
            }
        }
        return "";
    }

    private static String find(int n) {
        int[] nums = new int[9];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 10;
        }
        int length = -1;
        while(n>0){
            int part = n%10;
            n/=10;
            nums[++length] = part;
        }
        Arrays.sort(nums);
        StringBuffer biggest = new StringBuffer();
        StringBuffer smallest = new StringBuffer();
        int biggestCounter = length;
        int smallestCounter = 0;
        while (biggestCounter>=0){
            biggest.append(nums[biggestCounter]);
            if(nums[smallestCounter]!=0) {
                smallest.append(nums[smallestCounter]);
            }
            biggestCounter--;
            smallestCounter++;
        }
        for (int i = smallest.length(); i <= length; i++) {
            smallest.append(0);
        }
        return biggest.toString()+" "+smallest.toString();
    }
}
