package io.dsa.divideandconquer;

public class EditString {

    public static void main(String[] args) {
        System.out.println(findMinOperation("table", "tbres"));
    }

    public static int findMinOperation(String s1, String s2) {
        return findMinOperation(s1, s2, 0, 0);
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

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
