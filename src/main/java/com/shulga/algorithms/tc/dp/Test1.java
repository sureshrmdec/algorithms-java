package com.shulga.algorithms.tc.dp;

/**
 * Created by eshulga on 9/25/15.
 * <p>
 * On a positive integer, you can perform any one of the following 3 steps. 1.) Subtract 1 from it. ( n = n - 1 )  , 2.) If its divisible by 2, divide by 2.
 * ( if n % 2 == 0 , then n = n / 2  )  , 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ).
 * Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
 * <p>
 * eg: 1.)For n = 1 , output: 0       2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )    3.)  For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )
 */
public class Test1 {

    int getMinStepsDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1 + dp[i - 1];
            if (i % 2 == 0) dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
        }
        return dp[n];
    }

    int getMinStepsMemorization(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return getMinStepsReq(n, memo);
    }

    int getMinStepsReq(int n, int[] memo) {
        if (n == 1) {
            return 0;
        }  // base case
        if (memo[n] != -1) {
            return memo[n];
        }  // we have solved it already :)
        int r = 1 + getMinStepsReq(n - 1, memo);  // '-1' step .  'r' will contain the optimal answer finally
        if (n % 2 == 0) {
            r = Math.min(r, 1 + getMinStepsReq(n / 2, memo));
        }  //  '/2' step
        if (n % 3 == 0) {
            r = Math.min(r, 1 + getMinStepsReq(n / 3, memo));
        }  //  '/3' step
        memo[n] = r;  // save the result. If you forget this step, then its same as plain recursion.
        return r;

    }

    int fib(int N,int[] dp){
        if(N<=1) return 1;
        int lookup = dp[N];
        if(lookup!=-1){
            return lookup;
        }
        dp[N] = fib(N-1,dp)+fib(N-2,dp);
        return dp[N];
    }

    int fib(int n){
        int one = 1;
        int two = 2;
        for (int i = 3; i <= n; i++) {
            int temp = one+two;
            one = two;
            two=temp;
        }
        return two;
    }

    public static void main(String[] args) {
        System.out.println(new Test1().getMinStepsMemorization(6));

        int[] ar =new int[5+1];
        for (int i = 0; i <= 5; i++) {
            ar[i] = -1;
        }
        System.out.println(new Test1().fib(5,ar));
        System.out.println(new Test1().fib(5));
    }
}
