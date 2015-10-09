package com.shulga.algorithms.tc.math;

/**
 * Created by eshulga on 10/6/15.
 */
public class ElectionFraudDiv2 {

    String IsFraudulent(int[] percentages) {
        double lower = 0;
        double higher = 0;
        for (int i = 0; i < percentages.length; i++) {
            int percentage = percentages[i];
            lower += percentage > 0 ? percentage - 0.5 : 0;
            higher += percentage > 0 ? percentage + 0.49 : 0;
        }
        if (lower > 100 || higher < 100) {
            return "YES";
        }
        return "NN";
    }

    public static void main(String[] args) {
        System.out.println(new ElectionFraudDiv2().IsFraudulent(new int[]{13, 13, 13, 13, 13, 13, 13, 13}));
    }
}
