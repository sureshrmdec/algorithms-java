package com.shulga.tc.s678.d2;


public class ThePhantomMenace {

    public static void main(String[] args) {
        System.out.println(new ThePhantomMenace().find(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}));
        System.out.println(new ThePhantomMenace().find(new int[]{1}, new int[]{10}));
        System.out.println(new ThePhantomMenace().find(new int[]{2, 3, 5, 7, 11}, new int[]{1, 8, 13}));
    }

    public int find(int[] doors, int[] droids) {
        int res = 0;
        int maxDistTotal=0;
        for (int i = 0; i < doors.length; i++) {
            int minDist=Integer.MAX_VALUE;
            for (int j = 0; j < droids.length; j++) {
                minDist = Math.min(minDist,Math.abs(doors[i]-droids[j]));
            }
            if(maxDistTotal<minDist){
                maxDistTotal=minDist;
                res = doors[i];
            }
        }
        return res;
    }
}
