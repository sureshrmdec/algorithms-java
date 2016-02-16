package com.shulga.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array A[] and a number x, get the number if pairs in A[] with sum as x
 */
//TODO not working
public class CheckForPairInArray {

    public static void main(String[] args) {
        System.out.println("Ans: " + new CheckForPairInArray().run2(new int[]{2, 5, 6, 7, 9, 1, 3, 9}, 10));
    }

    public static int run2(int[] ar, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < ar.length; i++) {
            set.add(ar[i]);
        }
        int counter = 0;
        int tries = 0;
        while (tries <= set.size()) {
            Integer num = set.iterator().next();
            if (set.contains(sum - num)) {
                counter++;
                set.remove(num);
                set.remove(sum - num);
            } else {
                set.remove(num);
                set.add(num);
            }
            tries++;
        }
        return counter;
    }

    public static int run(int[] ar, int sum) {
        Arrays.sort(ar);
        int counter = 0;
        int length = ar.length;
        for (int i = 0; i < length; i++) {
            int index = Arrays.binarySearch(ar, sum - ar[i]);
            if (index >= 0) {
                counter++;
                remove(ar, length, index);
                length--;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(ar[i]);
        }
        return counter;
    }

    private static void remove(int[] ar, int length, int i) {
        for (int j = i + 1; j < length; j++, i++) {
            ar[i] = ar[j];
        }
    }


}
