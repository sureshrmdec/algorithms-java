package com.shulga.algorithms.matrix;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by eshulga on 11/4/16.
 * The question sounds hard, but the solution is easy and beautiful
 * Sparse vector is an array that contains a lot (call it 90%) zero values which means if you multiply element-wise 2 arrays/vectors, 90% of values will be 0.
 * To do multiplication efficiently we can represent vector as an array with non zero (index,value) pair. For example [0,0,10,20,0,0,100] array will look
 * like [(2,10),(3,20),(6,100)]. Very important property of this arrays is that they are ordered! Which means we can use binary search. The solution is to iterate over
 * the smallest array and for each element lookup if the same index is present in the second array. If it does, we have a match.
 * Given 2 arrays the time complexity is M*log(N) where M is the length of the smallest array.
 */
public class Multiply2SparseVectors {
    public static void main(String[] args) {
        Pair[] vector1 = {new Pair(1, 10), new Pair(10, 1), new Pair(13, 20)};
        Pair[] vector2 = {new Pair(0, 1), new Pair(1, 1), new Pair(12, 12), new Pair(13, 20)};
        System.out.println(new Multiply2SparseVectors().multiply(vector1, vector2));
    }

    private int multiply(Pair[] vector1, Pair[] vector2) {
        //Use the smallest vector
        Pair[] smaller = vector1;
        Pair[] longer = vector2;
        if (vector2.length < vector1.length) {
            smaller = vector2;
            longer = vector1;
        }
        int res = 0;
        for (Pair pair : smaller) {
            //find corresponding Pair in second array
            int vector2Index = Arrays.binarySearch(longer, pair, new Comparator<Pair>() {
                @Override
                public int compare(Pair pair, Pair t1) {
                    return Integer.compare(pair.index, t1.index);
                }
            });
            //if found, then multiply
            if (vector2Index >= 0) {
                res += pair.value * longer[vector2Index].value;
            }
        }
        return res;
    }

    static class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
