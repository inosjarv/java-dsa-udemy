package io.dsa.arrays;

public class MaxProductTwoNumbers {
    public int maxProduct(int[] arr) {
        int first = 0, second = 0;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else {
                second = Math.max(second, num);
            }
        }

        return (first - 1) * (second - 1);
    }
}
