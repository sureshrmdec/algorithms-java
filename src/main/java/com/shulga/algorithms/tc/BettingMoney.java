package com.shulga.algorithms.tc;

/**
 * Created by eshulga on 9/19/15.
 */
public class BettingMoney {

    public static int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult) {
        int rev = 0;
        int cost = 0;
        for (int i = 0; i < amounts.length; i++) {
            if (i != finalResult) {
                rev += amounts[i];
            } else {
                cost = amounts[i] * centsPerDollar[i];
            }
        }
        return rev * 100 - cost;
    }

    public static void main(String[] args) {

//        int[] amounts= {100,100,100,100};
        int[] amounts = {100};

//        int[] centsPerDollar={5,5,5,5};
        int[] centsPerDollar = {10};

        int finalResult = 0;

        System.out.println(moneyMade(amounts, centsPerDollar, finalResult));
    }
}
