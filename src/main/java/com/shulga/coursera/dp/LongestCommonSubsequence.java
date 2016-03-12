package com.shulga.coursera.dp;

/**
 * Created by eshulga on 3/8/16.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(new LongestCommonSubsequence().runDP(s1, s2, s1.length(), s2.length()));
        System.out.println(new LongestCommonSubsequence().runReq(s1, s2, s1.length(), s2.length()));
    }

    private int runReq(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + runReq(s1, s2, m - 1, n - 1);
        }
        return Math.max(
                runReq(s1, s2, m, n - 1),
                runReq(s1, s2, m - 1, n)
        );
    }

    private int runDP(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


//    private int runDP(String s1, String s2, int m, int n) {
//        int[][] dp = new int[m + 1][n + 1];
//        int i, j;
//        for (i = 0; i <= m; i++) {
//            for (j = 0; j <= n; j++) {
//                if (i == 0 || j == 0) {
//                    dp[i][j] = 0;
//                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        for (int k = 0; k <= m; k++) {
//            for (int l = 0; l <= n; l++) {
//                System.out.print(dp[k][l] + " ");
//            }
//            System.out.println();
//        }
//        return dp[m][n];
//    }


}
