package com.shulga.algorithms.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eugene on 9/19/16.
 */
public class FindLengthOfLongestContainedInterval {

    public static void main(String[] args) {
        System.out.println(new FindLengthOfLongestContainedInterval().run(new int[]{1, 5, 3, 9, 8, 6, -1, -4, 0, 2, -2}));
    }

    private int run(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxInterval = 0;
        while(!set.isEmpty()){
            int maxIntervalSoFar = 0;
            Integer next = set.iterator().next();
            set.remove(next);
            int upper = next;
            while(set.contains(++upper)){
                set.remove(upper);
                maxIntervalSoFar++;
            }
            int lower = next;
            while(set.contains(--lower)){
                set.remove(lower);
                maxIntervalSoFar++;
            }
            maxInterval = Math.max(maxInterval,maxIntervalSoFar+1);
        }
        return maxInterval;
    }
}
