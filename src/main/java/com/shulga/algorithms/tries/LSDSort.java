package com.shulga.algorithms.tries;

/**
 * Created by eshulga on 7/26/16.
 */
public class LSDSort {
    public static void main(String[] args) {
        String[] pairs = {"hello", "world", "month", "sssss","aaaaa"};
        new LSDSort().run(pairs, pairs[0].length());
        for (int i = 0; i < pairs.length; i++) {
            System.out.println(pairs[i]);
        }
    }

    private void run(String[] strings, int W) {
        int R = 256;
        int N = strings.length;
        String[] aux = new String[N];
        for (int d = W - 1; d > 0; d--) {
            int[] counts = new int[R + 1];
            for (int i = 0; i < N; i++) {
                counts[1 + strings[i].charAt(d)]++;
            }
            for (int i = 0; i < R; i++) {
                counts[i + 1] += counts[i];
            }
            for (int i = 0; i < N; i++) {
                aux[counts[strings[i].charAt(d)]++] = strings[i];
            }
            for (int i = 0; i < N; i++) {
                strings[i] = aux[i];
            }
        }
    }

}
