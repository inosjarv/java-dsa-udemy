package io.dsa.arrays;

import java.util.Arrays;

public class MiddleFunction {
    static int[] middle(int[] arr) {
        return Arrays.copyOfRange(arr, 1, arr.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(middle(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(middle(new int[]{1, 2, 3, 4})));
    }
}
