package com.shulga.algorithms.heap;

/**
 * How to check if a given array represents a Binary Heap?
 * Given an array, how to check if the given array represents a Binary Max-Heap.
 * <p>
 * Examples:
 * <p>
 * Input:  arr[] = {90, 15, 10, 7, 12, 2}
 * Output: True
 * The given array represents below tree
 * 90
 * /    \
 * 15      10
 * /  \     /
 * 7    12  2
 * The tree follows max-heap property as every
 * node is greater than all of its descendants.
 * <p>
 * <p>
 * Input:  arr[] = {9, 15, 10, 7, 12, 11}
 * Output: False
 * The given array represents below tree
 * 9
 * /    \
 * 15      10
 * /  \     /
 * 7    12  11
 * The tree doesn't follows max-heap property 9 is
 * smaller than 15 and 10, and 10 is smaller than 11.
 */
public class CheckIfArrayIsBinaryHeap {
    public static void main(String[] args) {
        int[] a = {90, 15, 10, 7, 12, 2};
        int[] ab = {9, 15, 10, 7, 12, 11};
        System.out.println(new CheckIfArrayIsBinaryHeap().check(a, 0));
        System.out.println(new CheckIfArrayIsBinaryHeap().check(ab, 0));
    }

    private String check(int[] A, int N) {
        if (N + 1 < (A.length - 1) / 2) {
            if (A[N] < A[2 * N + 1]) {
                return "False";
            }
            check(A, 2 * N + 1);
            if (N + 2 < (A.length - 1) / 2) {
                if (A[N] < A[2 * N + 2]) {
                    return "False";
                }
                check(A, 2 * N + 2);
            }
        }
        return "True";
    }
}
