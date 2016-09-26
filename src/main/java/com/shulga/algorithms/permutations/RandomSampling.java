package com.shulga.algorithms.permutations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by eugene on 9/13/16.
 */
public class RandomSampling {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        new RandomSampling().run(list);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    private void run(List<Integer> ar) {
        Random r = new Random();
        for (int i = 0; i < ar.size(); i++) {
            Collections.swap(ar, i, r.nextInt(i + ar.size() - i));
        }
    }
}
