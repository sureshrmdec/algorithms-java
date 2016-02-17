package com.shulga.algorithms.hr;

import java.util.Scanner;

/**
 * Created by eugene on 11/28/15.
 */
public class TwoString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String[] res = new String[Integer.valueOf(str)];
        for (int i = 0; i < res.length; i++) {
            String s1 = in.next();
            String s2 = in.next();
            int s1Length = s1.length();
            int s2Length = s2.length();
            int minLength = s1Length<s2Length?s1Length:s2Length;
            for (int j = 0; j <minLength; j++) {
                if(s2.charAt(j)==s1.charAt(j)){
                    System.out.println("YES");
                    break;
                }
                if(j==minLength-1){
                    System.out.println("NO");
                }
            }
        }
    }
}
