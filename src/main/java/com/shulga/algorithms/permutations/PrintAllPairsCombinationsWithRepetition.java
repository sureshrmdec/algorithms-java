package com.shulga.algorithms.permutations;

/**
 * Created by eshulga on 7/11/16.
 * Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from the given set.
 * For a given set of size n, there will be n^k possible strings of length k. The idea is to start from an empty output string (we call it prefix in following code).
 * One by one add all characters to prefix. For every character added, print all possible strings with current prefix by recursively calling for k equals to k-1.
 */
public class PrintAllPairsCombinationsWithRepetition {
    public static void main(String[] args) {
        String str = "abc";
        Counter c = new Counter();
        new PrintAllPairsCombinationsWithRepetition().run(str, 2, str.length(), c);
        System.out.println(c.counter);
    }

    private void run(String str, int k, int length, Counter c) {
        printAllPermutations(str, "", length, k, c);
    }

    private void printAllPermutations(String str, String prefix, int length, int k, Counter c) {
        if (k == 0) {
            System.out.println(prefix);
            c.counter++;
            return;
        }
        for (int i = 0; i < length; ++i) {
            String newPrefix = prefix + str.charAt(i);
            printAllPermutations(str, newPrefix, length, k - 1, c);
        }
    }

    static class Counter {
        int counter = 0;
    }
}
