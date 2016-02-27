package com.shulga.tc.div2practice;

/**
 * Created by eshulga on 10/13/15.
 */
public class GoodString {

    String isGood(String s){
        int countA = 0;
        int countB = 0;
        char[] ar = s.toCharArray();
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]=='a') countA++;
            if(ar[i]=='b') countB++;
        }
        if(countA==countB) return "Good";
        return "Bad";
    }

    public static void main(String[] args) {
        System.out.println(new GoodString().isGood("aaaaaaaabbbaaabaaabbabababababaabbbbaabbabbbbbbabb"));
    }
}
