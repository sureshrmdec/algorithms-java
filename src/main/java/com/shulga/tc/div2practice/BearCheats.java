package com.shulga.tc.div2practice;

/**
 * Created by eshulga on 10/13/15.
 */
public class BearCheats {

    String eyesight(int A, int B) {
        int a=A;
        int b= B;
        int aReminder=0;
        int bReminder = 0;
        int counter = 0;
        while (a > 0 && b > 0) {
            counter++;
            aReminder = a % 10;
            bReminder = b % 10;
            if(aReminder!=bReminder){
                break;
            }
            a/=10;
            b/=10;
        }
        int difference = (int) ((aReminder-bReminder)*Math.pow(10,counter-1));
        if(B+difference==A){
            return "Lucky";
        }
        return "glasses";
    }

    public String eyesight2(int A, int B) {
        int diff = 0;
        while(A > 0) {
            if(A % 10 != B % 10) diff++;
            if(diff > 1) return "glasses";
            A/=10; B/=10;
        }
        return "happy";
    }

    public static void main(String[] args) {
        System.out.println(new BearCheats().eyesight(385900, 123000));
    }
}
