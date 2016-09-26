package com.shulga.algorithms.BST;

import java.util.*;

/**
 * Created by eugene on 9/4/16.
 */
public class ClosestEntriesInSortedArray {
    static class ArrayData implements Comparable<ArrayData> {
        private int index;
        private int value;

        ArrayData(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(ArrayData o) {
            int res = Integer.compare(value, o.value);
            if (res == 0) {
                res = Integer.compare(index, o.index);
            }
            return res;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof ArrayData)) {
                return false;
            }
            if (this == obj) {
                return true;
            }

            ArrayData data = (ArrayData) obj;
            return value == data.value && index == data.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, index);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> sortedLists = new ArrayList<>();
        sortedLists.add(Arrays.asList(5, 10, 14));
        sortedLists.add(Arrays.asList(3, 6, 9,12,15));
        sortedLists.add(Arrays.asList(8, 16, 24));
        System.out.println(new ClosestEntriesInSortedArray().run(sortedLists));
    }

    private int run(List<List<Integer>> sortedLists) {
        List<Integer> heads = new ArrayList<>(sortedLists.size());
        for (List<Integer> arr : sortedLists){
            heads.add(0);
        }
        NavigableSet<ArrayData> currentHeads = new TreeSet<>();
        for (int i = 0; i < sortedLists.size(); i++) {
            currentHeads.add(new ArrayData(i,sortedLists.get(i).get(heads.get(i))));
        }
        int res = Integer.MAX_VALUE;
        while(true){
            res = Math.min(res,currentHeads.last().value-currentHeads.first().value);
            int minindex = currentHeads.first().index;
            heads.set(minindex,heads.get(minindex)+1);
            if(heads.get(minindex)==sortedLists.get(minindex).size()){
                return res;
            }
            currentHeads.pollFirst();
            currentHeads.add(new ArrayData(minindex,sortedLists.get(minindex).get(heads.get(minindex))));
        }
    }
}
