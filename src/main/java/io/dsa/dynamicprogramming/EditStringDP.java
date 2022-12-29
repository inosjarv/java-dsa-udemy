package io.dsa.dynamicprogramming;

import java.util.Arrays;

public class EditStringDP {

    public static void main(String[] args) {
        System.out.println(findMinOperation("table", "tbres"));
        System.out.println(findMinOperationMemo("table", "tbres"));
        System.out.println(findMinOperationDP("table", "tbres"));
    }

    public static int findMinOperation(String s1, String s2) {
        return findMinOperation(s1, s2, 0, 0);
    }

    public static int findMinOperationMemo(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return findMinOperation(s1, s2, 0, 0, memo);
    }

    public static int findMinOperationDP(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) dp[i][0] = i;
        for (int j = 0; j < s2.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];

                else dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);

            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static int findMinOperation(String s1, String s2, int index1, int index2) {
        if (index1 == s1.length()) return s2.length() - index2;
        if (index2 == s2.length()) return s1.length() - index1;
        if (s1.charAt(index1) == s2.charAt(index2)) return findMinOperation(s1, s2, index1 + 1, index2 + 1);

        int deleteOp = 1 + findMinOperation(s1, s2, index1 + 1, index2);
        int insertOp = 1 + findMinOperation(s1, s2, index1 + 1, index2);
        int replaceOp = 1 + findMinOperation(s1, s2, index1 + 1, index2 + 1);
        return min(deleteOp, insertOp, replaceOp);
    }

    public static int findMinOperation(String s1, String s2, int index1, int index2, int[][] memo) {
        if (index1 == s1.length()) return s2.length() - index2;
        if (index2 == s2.length()) return s1.length() - index1;
        if (s1.charAt(index1) == s2.charAt(index2)) return findMinOperation(s1, s2, index1 + 1, index2 + 1);

        if (memo[index1][index2] != -1) {
            int deleteOp = 1 + findMinOperation(s1, s2, index1 + 1, index2, memo);
            int insertOp = 1 + findMinOperation(s1, s2, index1 + 1, index2, memo);
            int replaceOp = 1 + findMinOperation(s1, s2, index1 + 1, index2 + 1, memo);
            memo[index1][index2] = min(deleteOp, insertOp, replaceOp);
        }
        return memo[index1][index2];
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
