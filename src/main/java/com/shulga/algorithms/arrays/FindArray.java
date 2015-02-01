package com.shulga.algorithms.arrays;

/**
 * Find subarray in array. Return start index.
 * <p/>
 * Created by ievgen on 9/29/2014.
 */
public class FindArray {

    public static void main(String[] args) {
        int[] ar = {1, 5, 8, 7, 0, 5, 99};
        int[] subArray = {8, 7, 0, 5, 99};
        System.out.println(new FindArray().perform(subArray, ar));
    }

    public int perform(int[] subarray, int[] array) {
        if (subarray.length > array.length) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != subarray[0]) {
                continue;
            }
            int arrayPoint = i;
            int j = 0;
            int subPoint = j;
            while (array[arrayPoint] == subarray[subPoint]) {
                if (subPoint == subarray.length - 1) {
                    return i;
                }
                if (arrayPoint == array.length - 1) {
                    break;
                }
                arrayPoint++;
                subPoint++;
            }
        }
        return -1;
    }
}
