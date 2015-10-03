package com.shulga.algorithms;

/**
 * Created by eugene on 9/27/15.
 */
class Solution {
    public int solution(int[] A) {
        int[] ar = new int[A.length];
        ar[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            ar[i] = A[i]+A[i-1];
        }
        int sum = ar[A.length-1];
        if(sum-A[0]==0 || sum-A[A.length-2]==0){
            return 0;
        }
        for (int i = 1; i < A.length; i++) {
            if(A[i-1]==sum-A[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{-1,3,-4,5,1,-6,2,1}));
    }

}
