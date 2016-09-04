package com.shulga.algorithms.arrays;

/**
 * Given two sorted arrays A and B, generate all possible arrays such that first element
 * is taken from A then from B then from A and so on in increasing order till the arrays exhausted.
 * The generated arrays should end with an element from B.
 * <p>
 * For Example
 * A = {10, 15, 25}
 * B = {1, 5, 20, 30}
 * <p>
 * The resulting arrays are:
 * 10 20
 * 10 20 25 30
 * 10 30
 * 15 20
 * 15 20 25 30
 * 15 30
 * 25 30
 */
//TODO
public class GenerateAllPossibleSortedArrays {
    public static void main(String[] args) {
        System.out.println(new GenerateAllPossibleSortedArrays().run(new int[]{10, 15, 25}, new int[]{1, 5, 20, 30}));
    }




















    private int run(int[] ar1, int[] ar2) {
        return 0;
    }
}
