package com.shulga.algorithms.greedy;

/**
 * Created by eshulga on 10/21/16.
 *
 * A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.

 */
public class CanJump {
    public static void main(String[] args) {
        System.out.println(new CanJump().run(new int[]{25000}));
    }

    private boolean run(int[] nums) {
        int maxSoFar = 0;
        for (int i = 0; i < nums.length && maxSoFar>=i; i++) {
            if(maxSoFar>=nums.length-1) return true;
            maxSoFar = Math.max(i+nums[i],maxSoFar);
        }
        return maxSoFar>=nums.length-1;
    }
}
