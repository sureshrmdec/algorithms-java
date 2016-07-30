package com.shulga.tc.recursion;

/**
 * Created by eshulga on 7/27/16.
 */
public class DutchFlag {
    public static void main(String[] args) {
        int[] ints = {1, 3, 2, 1, 2, 3, 1, 2, 3};
        new DutchFlag().run(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public void exch(int[] ar, int i,int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    private void run(int[] ints) {
        int low=0;
        int mid = 0;
        int hi = ints.length-1;
        while(mid<=hi){
            switch (ints[mid]) {
                case 1:
                    exch(ints,low,mid);
                    low++;
                    mid++;
                    break;
                case 2:
                    mid++;
                    break;
                case 3:
                    exch(ints,mid,hi);
                    hi--;
                    break;
            }
        }
    }


}
