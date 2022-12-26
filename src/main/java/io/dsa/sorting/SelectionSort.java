package io.dsa.sorting;

import static io.dsa.sorting.SortingUtils.*;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int length = arr.length;
        for (int j = 0; j < length; j++) {
            int minIndex = j;

            for (int i = j + 1; i < length; i++) {
                if (arr[i] < arr[minIndex])
                    minIndex = i;
            }
            if (minIndex != j)
                swap(arr, minIndex, j);
        }

    }

    public static void main(String[] args) {
        int[] arr = randomNumbersArr(20);
        selectionSort(arr);
        printArr(arr);
    }
}
