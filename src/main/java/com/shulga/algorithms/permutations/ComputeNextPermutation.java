package com.shulga.algorithms.permutations;


/**
 * Created by eshulga on 8/30/16.
 */
public class ComputeNextPermutation {
    public static void main(String[] args) {
//        int[] run = new ComputeNextPermutation().run(new int[]{3,2,1});
        int[] run = new ComputeNextPermutation().run(new int[]{});
        for (int i = 0; i < run.length; i++) {
            System.out.print(run[i] + " ");
        }
    }

    private int[] run(int[] nums) {
        if(nums.length==0) return nums;
        int end = nums.length - 2;
        while (end>=0 && nums[end] > nums[end + 1]) {
            end--;
        }
        int s = end + 1, e = nums.length - 1;
        //reverse
        while (s < e) {
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;
        }
        if(end!=-1) {
            int tmp = nums[end];
            nums[end] = nums[end + 1];
            nums[end + 1] = tmp;
        }
        return nums;

    }
}
