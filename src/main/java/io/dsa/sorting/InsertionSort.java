package io.dsa.sorting;

import static io.dsa.sorting.SortingUtils.*;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {10, 34, 11, 56, 11, 1, 32};
        insertionSort(arr);
        printArr(arr);
    }

    public static void insertionSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int temp = arr[i], j = i;

            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
