package com.shulga.algorithms.permutations;

/**
 * Created by eshulga on 7/11/16.
 * Algorithm Paradigm: Backtracking
 * Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation
 * Draw recursion tree
 */
public class PrintAllPermutationOfAString {

    static class Counter{
        int counter=0;
    }

    public static void main(String[] args) {
        String s = "123";
        Counter c = new Counter();
        new PrintAllPermutationOfAString().run(s.toCharArray(), 0, s.length(), c);
        System.out.println(c.counter);

    }

    private void run(char[] ar, int start, int end, Counter c) {
        int j;
        if (start == end) {
            System.out.println(new String(ar));
            c.counter++;
        } else {
            for (j = start; j < end; j++) {
                swap(ar, start, j);
                run(ar, start + 1, end, c);
                swap(ar, start, j);
            }
        }
    }

    private void swap(char[] ar, int i, int j) {
        char tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }
}
