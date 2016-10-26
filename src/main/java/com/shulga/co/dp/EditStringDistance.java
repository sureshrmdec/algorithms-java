package com.shulga.co.dp;

/**
 * Created by eshulga on 3/7/16.
 * <p>
 * 0 1 2 3 4 5 6 7 8
 * 1 0 1 2 3 4 5 6 7
 * 2 1 1 2 2 3 4 5 6
 * 3 2 2 2 3 3 4 5 6
 * 4 3 3 3 3 4 3 4 5
 * 5 4 3 4 4 4 4 3 4
 * 6 5 4 4 5 5 5 4 3
 * 3
 */
public class EditStringDistance {

    public static void main(String[] args) {
        System.out.println(new EditStringDistance().runDP("sunday", ""));
//        System.out.println(new EditStringDistance().run("sunday", "saturday"));
    }

    private int runDP(String s1, String s2) {
        return runDPTask(s1, s2, s1.length(), s2.length());
    }

//    private int runDPTask(String s1, String s2, int m, int n) {
//        int[][] dp = new int[m + 1][n + 1];
//
//        //bottom up
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                if (i == 0) {
//                    dp[i][j] = j;
//                } else if (j == 0) {
//                    dp[i][j] = i;
//                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = 1 + min(
//                            dp[i][j - 1],
//                            dp[i - 1][j],
//                            dp[i - 1][j - 1]);
//                }
//            }
//        }
//        for (int i = 0; i < m + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        return dp[m][n];
//    }

    private int run(String s1, String s2) {
        return runTask(s1, s2, s1.length(), s2.length());
    }

    private int runTask(String s1, String s2, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return runTask(s1, s2, m - 1, n - 1);
        }
        return 1 + min(
                runTask(s1, s2, m - 1, n - 1),
                runTask(s1, s2, m, n - 1),
                runTask(s1, s2, m - 1, n)
        );
    }

    private int runDPTask(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        printMatrix(dp);
        return dp[m][n];
    }

    void printMatrix(int[][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int min(int i1, int i2, int i3) {
        return Math.min(i1, Math.min(i2, i3));
    }


}
