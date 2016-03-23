package com.shulga.coursera;

import java.util.*;

/**
 * Created by eshulga on 3/2/16.
 */
public class FractionalKnapsack {
    public static void main(String[] args) {
        System.out.println(new FractionalKnapsack().run(new Integer[]{60, 100, 120}, new int[]{20, 50, 30}, 50));
        System.out.println(new FractionalKnapsack().run(new Integer[]{500}, new int[]{30}, 10));
    }

    private Double run(Integer[] values, int[] weights, int W) {
        Map<Double, Integer> toWeights = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            double ratio = values[i] / new Double(weights[i]);
            toWeights.put(ratio, weights[i]);
        }
        List<Double> ratios = new ArrayList<>(toWeights.keySet());
        Collections.sort((ratios), Comparator.<Double>reverseOrder());
        Double totalValue = 0.0;
        int totalWeight = W;
        for (Double r : ratios) {
            int weight = Math.min(totalWeight, toWeights.get(r));
            totalWeight -= weight;
            totalValue += weight * r;
            if (totalWeight == 0) {
                break;
            }
        }
        return totalValue;
    }

}
