package com.shulga.algorithms.arrays;

/**
 * Created by eugene on 2/16/16.
 */
public class Find2BiggestElements {

    public static void main(String[] args) {
        System.out.println(new Find2BiggestElements().run(new int[]{7 ,5, 14, 2, 8, 8, 10, 1, 2, 3}));
    }

    private int run(int[] A) {
        int max=A[0];
        int preMax=0;
        for (int i = 1; i < A.length; i++) {
            if(A[i]>max){
                preMax=max;
                max = A[i];
            }else if(A[i]>preMax){
                preMax=A[i];
            }
        }
        return max*preMax;
    }
}
