package com.shulga.algorithms.hr;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by eugene on 11/28/15.
 */
public class Encryption {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
        String str = "feedthedog";
        int length = str.length();
        int squareRoot = (int) Math.sqrt(length);
        int columnCount = squareRoot;
        int rowsCount = squareRoot;

        int square = squareRoot * squareRoot;
        if(square < length){
            double diff = (double)(length-square)/(double)square;
            if((int)diff==1){
                columnCount++;
            }
            int half = (int) (diff / 2);
            rowsCount+= half;
            columnCount+=half;
            if(diff>(int)diff){
                columnCount++;
            }
        }
        char[][] res = new char[rowsCount][columnCount];
        int strCount = 0;
        for (int i = 0; i <rowsCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if(strCount==str.length()){
                    break;
                }
                res[i][j] = str.charAt(strCount);
                strCount++;
            }
        }
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < columnCount; i++) {
            if(i!=0) {
                buf.append(" ");
            }
            for (int j = 0; j < rowsCount; j++) {
                buf.append(res[j][i]);
            }
        }
        System.out.println(buf.toString());
    }

}
