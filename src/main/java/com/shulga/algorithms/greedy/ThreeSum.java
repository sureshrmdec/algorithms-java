package com.shulga.algorithms.greedy;

import java.util.Arrays;

/**
 * Created by eshulga on 9/26/16.
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(new ThreeSum().run(new int[]{1,4,5,7,8,10}, 6));
    }

    private boolean run(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= k) continue;
            int start = i+1;
            int end = nums.length - 1;
            while (start < end) {
                if (num + nums[start] + nums[end] == k) {
                    return true;
                } else if (num + nums[start] + nums[end] < k) {
                    start++;
                    if(num + nums[start] + nums[end] > k) break;
                } else {
                    end--;
                    if(num + nums[start] + nums[end] < k) break;
                }
            }
        }
        return false;
    }
}
