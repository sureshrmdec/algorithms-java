package com.shulga.arrays;

import java.util.HashSet;

/**
 * Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. Find the number in O(n) time & constant space.
 * <p>
 * Example:
 * I/P = [1, 2, 3, 2, 3, 1, 3]
 * O/P = 3
 */

//TODO using bitwise
public class FindtheNumberOccurringOddNumberOfTimes {

    public static void main(String[] args) {
        System.out.println("Ans: " + new FindtheNumberOccurringOddNumberOfTimes().run2(new int[]{1, 2, 3, 2, 3, 1, 3}));
    }

    public static int run2(int[] ar) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < ar.length; i++) {
            if (set.contains(ar[i])) {
                set.remove(ar[i]);
            } else {
                set.add(ar[i]);
            }
        }
        if (set.size() != 1) {
            System.out.println("More than 1 odd elements or absent");
        }
        return set.iterator().next();
    }
}
