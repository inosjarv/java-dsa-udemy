package io.dsa.sorting;

import io.dsa.Colors;

import java.util.*;
import java.util.stream.IntStream;

import static io.dsa.Colors.*;
import static io.dsa.sorting.SortingUtils.printArr;
import static io.dsa.sorting.SortingUtils.randomNumbersArr;

public class BucketSort {

    public static void main(String[] args) {
        int[] arr = randomNumbersArr(20);
        printArr(arr);
        System.out.println(RED + "======================================" +
                "========================================" + Colors.RESET);
        bucketSort(arr);
        printArr(arr);
    }

    public static void printBuckets(List<Integer>[] buckets) {
        System.out.println(YELLOW + "======================================================== Buckets ================" +
                "========================================" + Colors.RESET);
        System.out.println(CYAN + "\n" + Arrays.toString(buckets)
                + '\n' + Colors.RESET);
    }

    public static void bucketSort(int[] arr) {
        int length = arr.length;
        int numOfBuckets = (int) Math.ceil(Math.sqrt(length));

        int maxValue = Integer.MIN_VALUE;
        for (int num : arr) {
            maxValue = Math.max(num, maxValue);
        }

        List<Integer>[] buckets = new ArrayList[numOfBuckets];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int value : arr) {
            int bucketNumber = (int) Math.ceil(((float) value * numOfBuckets) / (float) maxValue);

            buckets[bucketNumber - 1].add(value);
        }

        for (List<Integer> bucket : buckets)
            Collections.sort(bucket);

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index] = value;
                index++;
            }
        }
    }
}
