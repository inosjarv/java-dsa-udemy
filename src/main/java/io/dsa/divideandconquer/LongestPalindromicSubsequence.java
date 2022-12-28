package io.dsa.divideandconquer;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(findLPS("ELRMENMET"));
    }

    public static int findLPS(String s) {
        return findLPS(s, 0, s.length() - 1);
    }

    private static int findLPS(String s, int startIdx, int endIdx) {
        if (startIdx > endIdx) return 0;

        if (startIdx == endIdx) return 1;

        int count1 = 0;

        if (s.charAt(startIdx) == s.charAt(endIdx))
            count1 = 2 + findLPS(s, startIdx + 1, endIdx - 1);

        int count2 = findLPS(s, startIdx, endIdx - 1);
        int count3 = findLPS(s, startIdx + 1, endIdx);
        return Math.max(count1, Math.max(count2, count3));
    }
}
