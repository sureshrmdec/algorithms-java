package com.shulga.tc.srm;
import java.util.*;
public class Cdgame {

    public int rescount(int[] a,int[] b){
        Set<Integer> unique = new HashSet<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < a.length; i++) {
            sum1+=a[i];
            sum2+=b[i];
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int tempSum2 = sum2-b[j]+a[i];
                int tempSum1 = sum1-a[i]+b[j];
                unique.add(tempSum1*tempSum2);
            }
        }
        return unique.size();
    }



}
