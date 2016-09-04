package com.shulga.algorithms.string;

/**
 * Created by eshulga on 8/18/16.
 */
public class InsertRemoveFromString {

    //b remove
    //a=>00
    public static void main(String[] args) {
        String s = "bb1a23a4b5b6";
        System.out.println(new InsertRemoveFromString().run(s));
    }

    private String run(String s) {
        char[] ar = s.toCharArray();
        int counter = 0;
        int aCount = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != 'b') {
                ar[counter] = ar[i];
                counter++;
            }
            if (ar[i] == 'a') {
                aCount++;
            }
        }
        int end = counter-1 + (aCount * 2);
        for (int i = end; i > 0; i--) {
            if (ar[counter] == 'a') {
                ar[i] = '0';
                ar[--i] = '0';
                aCount--;
            } else {
                ar[i] = ar[counter];
            }
            counter--;
        }
        return new String(ar);
    }

}
