package io.dsa.sorting;

import java.util.PriorityQueue;

import static io.dsa.sorting.SortingUtils.printArr;
import static io.dsa.sorting.SortingUtils.randomNumbersArr;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = randomNumbersArr(20);
        printArr(arr);
        heapSort(arr);
        printArr(arr);
    }

    public static void heapSort(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int value : arr) queue.add(value);

        int i = 0;
        while (!queue.isEmpty())
            arr[i++] = queue.poll();
    }
}
