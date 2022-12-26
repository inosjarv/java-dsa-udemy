package io.dsa.sorting;

import static io.dsa.sorting.SortingUtils.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = randomNumbersArr(20);
        printArr(arr);
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivotValue = arr[start];

        int count = 0;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= pivotValue) count++;
        }

        int pivotIndex = start + count;
        swap(arr, pivotIndex, start);

        int i = start, j = end;
        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] <= pivotValue) i++;
            while (arr[j] > pivotValue) j--;

            if (i < pivotIndex && j > pivotIndex)
                swap(arr, i++, j--);
        }

        return pivotIndex;
    }
}
