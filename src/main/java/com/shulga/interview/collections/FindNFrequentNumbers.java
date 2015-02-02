package com.shulga.interview.collections;

import java.util.*;

/**
 * Find the top k frequent items in a stream of numbers
 * <p>
 * Created by eshulga on 1/30/15.
 */
public class FindNFrequentNumbers {

    static List<Map.Entry<Integer,Integer>> getNFrequentNumbers(List<Integer> numbers, int k) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (Integer num : numbers) {
            Integer value = tempMap.get(num);
            if (value != null) {
                tempMap.put(num, ++value);
            } else {
                tempMap.put(num, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> tempList = new ArrayList<>(tempMap.entrySet());
        Collections.sort(tempList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<Map.Entry<Integer,Integer>> result = new ArrayList<>();
        for (int i = 0; i < k && i < numbers.size(); i++) {
            result.add(tempList.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(Math.abs(new Random().nextInt() % 10));
        }
        List<Map.Entry<Integer, Integer>> nFrequentNumbers = getNFrequentNumbers(list, 3);
        for (Map.Entry<Integer, Integer> entry: nFrequentNumbers) {
            System.out.println(entry.getKey() +" : "+entry.getValue());
        }
    }
}
