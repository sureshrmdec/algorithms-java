package com.shulga.algorithms.tries;

/**
 * Created by eshulga on 7/26/16.
 */
public class KeyIndexedCouting {
    public static void main(String[] args) {
        Pair[] pairs = {new Pair(1, "hello"), new Pair(3, "No"), new Pair(3, "Noasd"), new Pair(2, "No"), new Pair(2, "caco")};
        new KeyIndexedCouting().run(pairs);
        for (int i = 0; i < pairs.length; i++) {
            System.out.println(pairs[i].key + " " + pairs[i].value);
        }
    }

    private void run(Pair[] pairs) {
        int R = 4;
        int N = pairs.length;
        Pair[] aux = new Pair[N];
        int[] count = new int[R + 1];
        //compute frequency counts
        for (int i = 0; i < N; i++) {
            count[pairs[i].key + 1]++;
        }
        //transform counts to indices
        for (int i = 0; i < R; i++) {
            count[i + 1] += count[i];
        }
        //Distribute the records
        for (int i = 0; i < N; i++) {
            aux[count[pairs[i].key]++] = pairs[i];
        }
        //Copy back
        for (int i = 0; i < N; i++) {
            pairs[i] = aux[i];
        }
    }



    private static class Pair {
        int key;
        String value;

        public Pair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
