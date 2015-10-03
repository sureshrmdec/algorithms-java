package com.shulga.algorithms.tc;

/**
 * Created by eugene on 9/29/15.
 */
public class CountryGroup {
    public int solve(int[] a){
        int len = a.length;
        int i=0;
        int count=0;
        while(i<len){
            int x=a[i];
            for(int j=i+1; j<i+x; j++){
                if(j>=len) return -1;
                else if(a[j]!=x) return -1;
            }
            count++;
            i+=x;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountryGroup().solve(new int[]{2,2,1,2,2,1}));
    }
}
