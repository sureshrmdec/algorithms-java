package com.shulga.algorithms.tc.div2practice;

/**
 * Created by eshulga on 10/13/15.
 */
public class LuckyXor {

    int construct(int a){
        int result;
        int attempt = a+1;
        while(attempt<=100){
            result = a^attempt;
            if(attempt>a && isLucky(result)){
                return attempt;
            }
            attempt++;
        }
        return -1;
    }

    private boolean isLucky(int result) {
        while (result>0){
            int remider = result%10;
            if(remider!=4 && remider!=7){
                return false;
            }
            result= result/10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LuckyXor().construct(36));
    }
}
