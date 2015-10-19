package com.shulga.algorithms.tc.srm;

/**
 * Created by eugene on 10/10/15.
 */
public class Drbalance {

    public int lesscng(String s,int k){
        char[] chars = s.toCharArray();
        int startNeg = getNegNumber(chars);
        if(startNeg==k){
            return 0;
        }
        for (int i = 0; i < chars.length; i++) {
            flip(chars,i);
            for (int j = 0; j < chars.length; j++) {
                if(getNegNumber(chars)==k)
                if(j==i) continue;
                flip(chars,j);
            }
        }
        return startNeg;
    }

    private int getNegNumber(char[] chars){
        int startNeg=0;
        for (int i = 0; i < chars.length; i++) {
            int sum = 0;
            for (int j = 0; j <=i; j++) {
                if(chars[j]=='-'){
                    sum--;
                }else{
                    sum++;
                }
            }
            if(sum>=0){
                startNeg++;
            }else{
                startNeg--;
            }
        }
        return startNeg;
    }

    private void flip(char[] ar,int j){
        if(ar[j]=='-'){
            ar[j]='+';
        }else{
            ar[j] = '-';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Drbalance().lesscng("---",1));
    }
}
