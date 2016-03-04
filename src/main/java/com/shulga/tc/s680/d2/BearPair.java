package com.shulga.tc.s680.d2;

public class BearPair {

    public int bigDistance(String s) {
        char[] ar = s.toCharArray();
        int max = -1;
        for (int j = 0; j < ar.length; j++) {
            for (int i = s.length() - 1; i > 0; i--) {
                if(i-j<max){
                    break;
                }
                if(ar[j]!=ar[i]){
                    max = Math.max(max,i-j);
                }
            }
        }
        return max;
    }
}
