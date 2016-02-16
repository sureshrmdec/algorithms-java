package com.shulga.algorithms.tc.srm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eshulga on 10/14/15.
 */
public class BearDartsDiv2 {

    public long count(int[] w) {
        int c = 0;
        for (int i = 0; i < w.length - 2; i++) {
            for (int j = i + 1; j < w.length - 1; j++) {
                for (int k = j + 1; k < w.length; k++) {
                    for (int l = k + 1; l < w.length; l++) {
                        int mult = w[i] * w[j] * w[k];
                        if (w[l] == mult) {
                            c++;
                        }
                    }
                }
            }
        }
        return c;
    }

    public long count2(int[] w) {
        Map<Long, Map<Integer, Integer>> dp = new HashMap<>();
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < i; j++) {
                long key = w[i] * w[j];
                Map<Integer, Integer> integerIntegerMap = dp.get(key);
                if (integerIntegerMap == null) {
                    integerIntegerMap = new HashMap<>();
                    dp.put(key, integerIntegerMap);
                }
                for (int k = i; k < w.length; k++) {
                    Integer integer = integerIntegerMap.get(k);
                    if (integer == null) {
                        integerIntegerMap.put(k, 1);
                    } else {
                        integerIntegerMap.put(k, integer + 1);
                    }
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < w.length; i++) {
            for (int j = 1; j < i; j++) {
                if (w[i] % w[j] == 0) {
                    int r = w[i] / w[j];
                    Map<Integer, Integer> integerIntegerMap = dp.get(r);
                    if (integerIntegerMap != null) {
                        Integer count = integerIntegerMap.get(j - 1);
                        if (count != null) {
                            sum += count;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(new BearDartsDiv2().count2(new int[]{10, 2, 2, 7, 40, 160}));
        System.out.println(new BearDartsDiv2().count(new int[]{10, 2, 2, 7, 40, 160}));
    }
}
