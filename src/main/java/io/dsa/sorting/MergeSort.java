package io.dsa.sorting;

import static io.dsa.sorting.SortingUtils.printArr;
import static io.dsa.sorting.SortingUtils.randomNumbersArr;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = randomNumbersArr(20);
        printArr(arr);
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (end > start) {
            int middle = start + (end - start) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);

        }
    }

    public static void merge(int[] arr, int start, int middle, int end) {
        int len1 = middle - start + 1, len2 = end - middle;

        int[] firstArr = new int[len1];
        int[] secondArr = new int[len2];

        int mainArrayIndex = start;
        for (int i = 0; i < len1; i++) {
            firstArr[i] = arr[mainArrayIndex++];
        }

        for (int i = 0; i < len2; i++) {
            secondArr[i] = arr[mainArrayIndex++];
        }

        int idx1 = 0, idx2 = 0;
        mainArrayIndex = start;
        while (idx1 < len1 && idx2 < len2) {
            if (firstArr[idx1] < secondArr[idx2]) arr[mainArrayIndex++] = firstArr[idx1++];
            else arr[mainArrayIndex++] = secondArr[idx2++];
        }

        while (idx1 < len1) arr[mainArrayIndex++] = firstArr[idx1++];

        while (idx2 < len2) arr[mainArrayIndex++] = secondArr[idx2++];
    }

}
