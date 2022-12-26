package io.dsa.sorting;

import java.util.Arrays;

import static io.dsa.sorting.SortingUtils.*;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++)
            for (int j = 0; j < length - i - 1; j++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);

    }

    public static void main(String[] args) {
        int[] arr = {10, 34, 11, 56, 11, 1, 32};
        bubbleSort(arr);
        printArr(arr);
    }
}
