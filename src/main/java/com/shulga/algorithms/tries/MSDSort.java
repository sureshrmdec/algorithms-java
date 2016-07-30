package com.shulga.algorithms.tries;

/**
 * Created by eshulga on 7/27/16.
 */
public class MSDSort {
    int R = 256;
    String[] aux;

    public static void main(String[] args) {
        String[] a = {"she", "sells", "seashells", "by", "the", "sea", "shore", "surely", "seashells"};
        new MSDSort().run(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    private void run(String[] a) {
        aux = new String[a.length];
        sort(a, 0, a.length, 0);
    }

    private void sort(String[] a, int lo, int hi, int d) {
        if (hi > lo) return;
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }
        for (int i = 0; i < R + 1; i++) {
            count[i + 1] += count[i];
        }
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        //Recursively sort for each character value
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

}
