package com.shulga.algorithms.bits;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a
 * method to set all bits between i and j in N equal to M (e.g., M becomes a substring of
 * N located at i and starting at j).
 * EXAMPLE:
 * Input: N = 10000000000, M = 10101, i = 2, j = 6
 * Output: N = 10001010100
 * <p>
 * <p>
 * <p>
 * Created by ievgen on 11/8/14.
 */
public class Bit1 {

    public static int updateBits(int n, int m, int i, int j) {

        int max = ~0; /* All 1’s */
        String binary = Integer.toBinaryString(max);
        System.out.println(binary + " count:" + binary.length());


        // 1’s through position j, then 0’s

        int left = max - ((1 << j) - 1);
        binary = Integer.toBinaryString(left);
        System.out.println(binary + " count:" + binary.length());

        // 1’s after position i
        int right = ((1 << i) - 1);
        binary = Integer.toBinaryString(right);
        System.out.println(binary + " count:" + binary.length());
        // 1’s, with 0s between i and j
        int mask = left | right;
        binary = Integer.toBinaryString(mask);
        System.out.println(binary + " count:" + binary.length());
        // Clear i through j, then put m in there
        int i1 = n & mask;
        binary = Integer.toBinaryString(i1);
        System.out.println(binary + " count:" + binary.length());
        int i2 = m << i;
        binary = Integer.toBinaryString(i2);
        System.out.println(binary + " count:" + binary.length());
        int res = i1 | i2;
        binary = Integer.toBinaryString(res);
        System.out.println(binary + " count:" + binary.length());
        return res;
    }

    public static void main(String[] args) {
        updateBits(1000000000, 10101, 2, 6);
    }
}
