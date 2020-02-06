package com.algorithm.DP;

/**
 * create by Ernest on 2020/2/6.
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1]; // (m,n) Matrix

        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }


        for (int i = 1; i < m + 1; i++) {
            // dp[i][0] = i;
            for (int j = 1; j < n + 1; j++) {
                // dp[0][j] = j;
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
