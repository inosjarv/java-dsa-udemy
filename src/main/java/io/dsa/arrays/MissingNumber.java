package io.dsa.arrays;

public class MissingNumber {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int total = n * (n + 1) / 2;
        for (int num: arr) sum += num;
        return total - sum;
    }
}
