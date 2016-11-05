package com.shulga.recursion;

/**
 * Created by eshulga on 10/1/15.
 */
public class Fibbonachi {

    public int fibReq(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        int first = fibReq(N - 2);
        int second = fibReq(N - 1);
        return first + second;
    }

    public int fibLoop(int N) {
        int first = 0;
        int second = 1;
        int result=0;
        int count = 3;
        while(count<=N){
            result=first+second;
            first = second;
            second = result;
            count++;
        }
        return result;
    }

    public int fib(int N) {
        int[] temp = new int[N+1];
        for (int i = 1; i < temp.length; i++) {
            temp[i] = -1;
        }
        temp[1] = 0;
        temp[2] = 1;
        int i = fibMemorize(temp, N);
        return i;
    }

    private int fibMemorize(int[] temp, int n) {
        if (temp[n] != -1) {
            return temp[n];
        }
        int first = fibMemorize(temp, n - 1);
        int second = fibMemorize(temp, n - 2);
        temp[n] = first + second;
        return temp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Fibbonachi().fibReq(9));
        System.out.println(new Fibbonachi().fib(9));
        System.out.println(new Fibbonachi().fibLoop(9));
    }
}
