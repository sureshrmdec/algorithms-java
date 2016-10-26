package com.shulga.algorithms.bits;

/**
 * Created by eshulga on 9/29/15.
 */
public class BasicOps {

    public static void main(String args[]) {
        int a = 60;	/* 60 = 0011 1100 */
        int b = 13;	/* 13 = 0000 1101 */
        int c;
        System.out.println("a=" + Integer.toBinaryString(a));
        System.out.println("b=" + Integer.toBinaryString(b));

        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c + ", " + Integer.toBinaryString(c));
//
        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c + ", " + Integer.toBinaryString(c));
//
        c = a ^ b;       /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c + ", " + Integer.toBinaryString(c));
//
        c = ~a;          /*-61 = 1100 0011 */
        System.out.println("~a = " + c + ", " + Integer.toBinaryString(c));
//
        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c + ", " + Integer.toBinaryString(c));
//
        c = a >> 2;     /* 215 = 1111 */
        System.out.println("a >> 2  = " + c + ", " + Integer.toBinaryString(c));
//
        c = a >>> 2;     /* 215 = 0000 1111 */
        System.out.println("a >>> 2 = " + c + ", " + Integer.toBinaryString(c));
        System.out.println("===========end==========");
//
        byte q = (byte) 16;
        System.out.println(q);
        q = (byte) (q >> 2);
//        // prints 4
        System.out.println(q);
//        System.out.println(Integer.toBinaryString(60));
//        System.out.println(Integer.toBinaryString(127));
    }
}