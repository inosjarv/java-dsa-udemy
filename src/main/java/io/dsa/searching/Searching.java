package io.dsa.searching;

public class Searching {

    public static void main(String[] args) {
        System.out.println("================ Linear Searching ================");
        int[] arr = {1, 2, 23, 65, 12, 98, 100, 120, 130};
        System.out.println(linearSearch(arr, 100));
        System.out.println(linearSearch(arr, 12));
        System.out.println(linearSearch(arr, 1122));

        System.out.println("================ Binary Searching ================");
        int[] sortedArr = {12, 23, 34, 45, 56, 67, 78, 89, 90, 100, 120};
        System.out.println(binarySearch(sortedArr, 34));
        System.out.println(binarySearch(sortedArr, 25));
        System.out.println(binarySearch(sortedArr, 67));
        System.out.println(binarySearch(sortedArr, 120));
    }

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) return mid;

            if (key < arr[mid]) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}
