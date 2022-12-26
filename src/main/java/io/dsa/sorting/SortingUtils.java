package io.dsa.sorting;

import io.dsa.Colors;

import java.util.Arrays;

import static io.dsa.Colors.*;

public class SortingUtils {
    private SortingUtils(){}

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr) {
        System.out.println(GREEN + Arrays.toString(arr) + Colors.RESET);
    }
}
