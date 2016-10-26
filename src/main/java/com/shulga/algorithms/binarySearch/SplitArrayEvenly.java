package com.shulga.algorithms.binarySearch;

/**
 * Created by eugene on 10/2/16.
 * <p/>
 * Given a result, it is easy to test whether it is valid or not.
 * The max of the result is the sum of the input nums.
 * The min of the result is the max num of the input nums.
 */
public class SplitArrayEvenly {
    public static void main(String[] args) {
        System.out.println(new SplitArrayEvenly().run(new int[]{1, 2, 3, 4, 5, 6}, 3));
    }

    private int run(int[] nums, int m) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.max(nums[i], min);
            max += nums[i];
        }
        if (m == 1) return max;
        int low = min;
        int upper = max;
        while (low <= upper) {
            int mid = low + (upper - low) / 2;
            if (isEnough(nums, mid, m)) {
                upper = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isEnough(int[] nums, int mid, int m) {
        int count = 1;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            if (current > mid) {
                current = nums[i];
                count++;
            }
            if (count > m) {
                return false;
            }
        }
        return true;
    }

}
