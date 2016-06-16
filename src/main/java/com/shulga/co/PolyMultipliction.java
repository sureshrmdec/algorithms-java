package com.shulga.co;

/**
 * Created by eugene on 3/5/16.
 */
public class PolyMultipliction {
    public static void main(String[] args) {
        int[] res = new PolyMultipliction().run(new int[]{3,2,5},new int[]{5,1,2});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]+" ");
        }
    }

    private int[] run(int[] one, int[] two) {
        int[] smaller;
        int[] bigger;
        if(one.length<two.length){
            smaller = one;
            bigger = two;
        }else{
            smaller = two;
            bigger = one;
        }
        int[][] mult = new int[smaller.length][bigger.length];
        for (int i = 0; i < smaller.length; i++) {
            for (int j = 0; j < bigger.length; j++) {
                mult[i][j] = smaller[i]*bigger[j];
            }
        }
        int[] res = new int[smaller.length+bigger.length-1];
        for (int i = 0; i < smaller.length; i++) {
            for (int j = 0; j < bigger.length; j++) {
                res[i+j] = res[i+j] + mult[i][j];
            }
        }
        return res;
    }
}
