package com.shulga.algorithms.sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eshulga on 8/23/16.
 */
public class PartitioningOfRepeatedElements {
    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 2, 3};
        new PartitioningOfRepeatedElements().run(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }

    private void run(int[] ints) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            int current = ints[i];
            if(map.containsKey(current)){
                map.put(current,map.get(current)+1);
            }else{
                map.put(current,1);
            }
        }
        int counter = 0;
        for (Integer v:map.keySet()){
            for (int i = 0; i < map.get(v); i++) {
                ints[counter++] = v;
            }
        }
    }
}
