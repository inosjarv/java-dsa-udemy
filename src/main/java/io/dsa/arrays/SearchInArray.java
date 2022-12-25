package io.dsa.arrays;

public class SearchInArray {
    public int searchInArray(int[] arr, int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToSearch) return i;
        }
        return -1;
    }
}
