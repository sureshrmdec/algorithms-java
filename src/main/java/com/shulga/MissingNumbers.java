package com.shulga;

import java.util.*;

/**
 * Created by eshulga on 2/24/16.
 */
public class MissingNumbers {
    public static void main(String[] args) {
        int[] A = new int[]{203};
        int[] B = new int[]{203, 555, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        int smallerLength = A.length < B.length ? A.length : B.length;
        int biggerLength = A.length > B.length ? A.length : B.length;

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < smallerLength; i++) {
            processA(A[i], map);
            processB(B[i], map);
        }
        if(biggerLength==B.length){
            for (int i = smallerLength; i <biggerLength ; i++) {
                processB(B[i], map);
            }
        }else{
            for (int i = smallerLength; i <biggerLength ; i++) {
                processA(A[i], map);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> counter:map.entrySet()) {
            if(counter.getValue()!=0) {
                set.add(counter.getKey());
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (Integer counter:list) {
            System.out.print(counter + " ");
        }
    }

    private static void processA(int ai,  Map<Integer, Integer> map) {
        if (map.get(ai) == null) {
            map.put(ai, 1);
        }else{
            map.put(ai, map.get(ai) +1);
        }
    }
    private static void processB(int bi, Map<Integer, Integer> map) {
        if (map.get(bi) == null) {
            map.put(bi, -1);
        }else{
            map.put(bi, map.get(bi)-1);
        }
    }
}
