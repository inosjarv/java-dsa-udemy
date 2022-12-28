package io.dsa.divideandconquer;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(findLCS("elephance", "erepat"));
    }

    public static int findLCS(String s1, String s2) {
        return findLCS(s1, s2, 0, 0);
    }

    private static int findLCS(String s1, String s2, int idx1, int idx2) {
        if (idx1 == s1.length() || idx2 == s2.length()) return 0;

        if (s1.charAt(idx1) == s2.charAt(idx2)) return 1 + findLCS(s1, s2, idx1 + 1, idx2 + 1);

        return Math.max(findLCS(s1, s2, idx1, idx2 + 1), findLCS(s1, s2, idx1 + 1, idx2));
    }
}
