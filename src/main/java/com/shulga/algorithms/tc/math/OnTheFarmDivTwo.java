package com.shulga.algorithms.tc.math;

/**
 * Created by eshulga on 10/7/15.
 */
public class OnTheFarmDivTwo {

    int[] animals(int heads, int legs) {
        int cantidad[] = new int[2];

        if (legs % 2 != 0) {
            return new int[0];
        }

        cantidad[0] = (4 * heads - legs) / 2;

        cantidad[1] = heads - cantidad[0];

        if (cantidad[0] < 0 || cantidad[1] < 0) {
            return new int[0];
        }

        return cantidad;
    }

    public static void main(String[] args) {
        int[] animals = new OnTheFarmDivTwo().animals(3, 8);
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
    }
}
