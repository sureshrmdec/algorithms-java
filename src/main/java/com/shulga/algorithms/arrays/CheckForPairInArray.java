package com.shulga.algorithms.arrays;

import java.util.*;

/**
 * Given an array A[] and a number x, get the number if pairs in A[] with sum as x
 */
//TODO not working
public class CheckForPairInArray {
    //private static int[] a = {5, 6, 33, -1, 2, 3, 8, -33};
    private static int[] a = {2, 5, 6, 7, 9, 1, 3, 9};
    //private static int sum = 68;
    private static int sum = 10;
    private static HashSet<Integer> numbers = new HashSet<>();


    public static void maisn(String[] args) {
        System.out.println("Ans: " + new CheckForPairInArray().run3(new int[]{5, 5,5}, 10));
    }

    public static void main(String[] args) {
        int pairsCounter = 0;
        for (int a1 : a) {
            numbers.add(a1);
        }
        for (int a1 : a) {
            double pow = Math.pow(a1, 2);
            if (sum < pow) continue;
            double sqrt = Math.sqrt(sum - pow);
            long real = (long) sqrt;
            double fract = sqrt - real;
            if (fract != 0) continue;
            if (numbers.contains((int) sqrt) && numbers.contains(a1)) pairsCounter++;
            numbers.remove((int)sqrt);
        }

        System.out.println("Pairs: " + pairsCounter);
    }




    public static int run3(int[] ar, int sum) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            map.put(ar[i],true);
        }
        int counter = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if(!map.get(num)){
                continue;
            }
            map.put(num,false);
            if (map.containsKey(sum - num) && map.get(sum - num)) {
                counter++;
                map.put(sum-num,false);
            }
        }
        return counter;
    }


    public static int run2(int[] ar, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < ar.length; i++) {
            set.add(ar[i]);
        }
        int counter = 0;
        int tries = 0;
        Iterator<Integer> iterator = set.iterator();
        while (tries < set.size() && iterator.hasNext()) {
            Integer num = iterator.next();
            if (set.contains(sum - num)) {
                counter++;
                iterator.remove();
                Iterator<Integer> innerIt = set.iterator();
                while (innerIt.hasNext()) {
                    if (innerIt.next() == sum - num) {
                        innerIt.remove();
                    }
                }
            }
            tries++;
        }
        return counter;
    }


    public static int run(int[] ar, int sum) {
        Arrays.sort(ar);
        int counter = 0;
        int length = ar.length;
        for (int i = 0; i < length; i++) {
            int index = Arrays.binarySearch(ar, sum - ar[i]);
            if (index >= 0) {
                counter++;
                remove(ar, length, index);
                length--;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(ar[i]);
        }
        return counter;
    }

    private static void remove(int[] ar, int length, int i) {
        for (int j = i + 1; j < length; j++, i++) {
            ar[i] = ar[j];
        }
    }


}
