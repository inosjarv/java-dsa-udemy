package io.dsa.dynamicprogramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(findLCS("ABCBDAB", "BDCABA"));
        System.out.println(lcs("ABCBDAB", "BDCABA"));
    }

    public static int findLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length(); i >= 1; i--) {
            for (int j = s2.length(); j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i - 1][j - 1] = Math.max(1 + dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                else dp[i - 1][j - 1] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][0];
    }

    public static String lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) i--;
            else j--;
        }

        return String.valueOf(sb.reverse());
    }
}
