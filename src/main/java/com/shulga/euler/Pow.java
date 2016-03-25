package com.shulga.euler;

/**
 * Created by eshulga on 3/22/16.
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(new Pow().run(2, 6));
    }

    private int run(int num, int power) {
        if (power == 0) {
            return 1;
        } else if (power % 2 == 0) {
            return run(num, power / 2) * run(num, power / 2);
        } else {

            return num * run(num, power / 2) * run(num, power / 2);
        }
    }

    private int runFast(int num, int power) {
        if (power == 0) {
            return 1;
        }
        int temp = run(num, power / 2);
        if (power % 2 == 0) {
            return temp * temp;
        } else {
            return num * temp * temp;
        }
    }
}
