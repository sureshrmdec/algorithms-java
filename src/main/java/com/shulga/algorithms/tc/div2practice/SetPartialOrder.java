package com.shulga.algorithms.tc.div2practice;

import java.util.Arrays;

/**
 * Created by eshulga on 10/22/15.
 */
public class SetPartialOrder {

    String compareSets(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int c = 0;
        int[] smaller;
        int[] bigger;
        if (a.length <= b.length) {
            smaller = a;
            bigger = b;
        } else {
            smaller = b;
            bigger = a;
        }
        for (int i = 0; i < smaller.length; i++) {
            if (Arrays.binarySearch(bigger, smaller[i]) >= 0) {
                c++;
            }
        }
        if (c == smaller.length) {
            if (smaller.length == bigger.length) {
                return "EQUALS";
            } else if (bigger.length != smaller.length && smaller.length==a.length) {
                return "LESS";
            } else {
                return "GREATER";
            }
        } else {
            return "INCOMPITABLE";
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5, 8};
        int[] b = {8, 5, 1, 3, 2};
        System.out.println(new SetPartialOrder().compareSets(a, b));
        a = new int[]{42, 23, 17};
        b = new int[]{15, 23, 31};
        System.out.println(new SetPartialOrder().compareSets(a, b));
        a = new int[]{2, 4, 6, 8, 10, 12, 14, 16};
        b = new int[]{2, 4, 8, 16};
        System.out.println(new SetPartialOrder().compareSets(a, b));
        a = new int[]{2, 3, 5, 7};
        b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new SetPartialOrder().compareSets(a, b));
    }
}
