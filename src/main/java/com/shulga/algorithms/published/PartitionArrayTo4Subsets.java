package com.shulga.algorithms.published;

/**
 * Created by eugene on 1/8/17.
 */
public class PartitionArrayTo4Subsets {

    public static void main(String[] args) {

        System.out.println(new PartitionArrayTo4Subsets().formSquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(new PartitionArrayTo4Subsets().formSquare(new int[]{3, 3, 3, 3, 4}));

    }


    public boolean formSquare(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //if sum can't be devided by 4 or less than 3 numbers are given, we can't form a square
        if (sum % 4 != 0 || nums.length < 4) return false;
        //running recursive DFS
        return formSquareDFS(nums, 0, new int[4], sum / 4);

    }

    private boolean formSquareDFS(int[] nums, int i, int[] sums, int K) {
        if (i == nums.length) {
            if (sums[0] == K && sums[1] == K && sums[2] == K && sums[3] == K) {
                return true;
            } else {
                return false;
            }
        }
        for (int j = 0; j < sums.length; j++) {
            if (sums[j] + nums[i] > K) continue;
            //add number
            sums[j] += nums[i];
            //if method returned true, propagate it up
            if (formSquareDFS(nums, i + 1, sums, K)) return true;
            //removed processed number
            sums[j] -= nums[i];
        }
        return false;
    }

    private boolean makesquareReq(int[] nums, int i, int sum1, int sum2, int sum3, int sum4, int K) {
        if (sum1 > K || sum2 > K || sum3 > K || sum4 > K) {
            return false;
        }
        if (i == -1) {
            if (sum1 == K && sum2 == K && sum3 == K && sum4 == K) {
                return true;
            } else {
                return false;
            }
        }
        return makesquareReq(nums, i - 1, sum1 + nums[i], sum2, sum3, sum4, K) ||
                makesquareReq(nums, i - 1, sum1, sum2 + nums[i], sum3, sum4, K) ||
                makesquareReq(nums, i - 1, sum1, sum2, sum3 + nums[i], sum4, K) ||
                makesquareReq(nums, i - 1, sum1, sum2, sum3, sum4 + nums[i], K);
    }
}
