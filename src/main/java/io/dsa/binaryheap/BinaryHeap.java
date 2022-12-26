package io.dsa.binaryheap;

import static io.dsa.Colors.*;

public class BinaryHeap {
    private static final String MIN_HEAP = "min";
    private static final String MAX_HEAP = "max";
    int[] arr;
    int sizeOfTree;

    public BinaryHeap(int size) {
        this.arr = new int[size + 1];
        this.sizeOfTree = 0;

        colorPrintln("BinaryHeap Created!!", YELLOW);
    }

    public static void main(String[] args) {
        BinaryHeap minHeap = new BinaryHeap(10);
        minHeap.insert(1, MIN_HEAP);
        minHeap.insert(5, MIN_HEAP);
        minHeap.insert(10, MIN_HEAP);
        minHeap.levelOrder();
        minHeap.insert(25, MIN_HEAP);
        minHeap.levelOrder();

        colorPrintln("Head of heap is: " + minHeap.extractHead(MIN_HEAP), GREEN);

        colorPrint("\n=========================================\n", CYAN);

        BinaryHeap maxHeap = new BinaryHeap(10);
        maxHeap.insert(1, MAX_HEAP);
        maxHeap.insert(5, MAX_HEAP);
        maxHeap.insert(10, MAX_HEAP);
        maxHeap.levelOrder();
        maxHeap.insert(25, MAX_HEAP);
        maxHeap.levelOrder();
        colorPrintln("Head of heap is: " + maxHeap.extractHead(MAX_HEAP), GREEN);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isEmpty() {
        return sizeOfTree == 0;
    }

    public Integer peek() {
        if (isEmpty()) {
            colorPrintln("BinaryHeap is Empty!!", RED);
            return null;
        }
        return arr[1];
    }

    public int getSizeOfTree() {
        return this.sizeOfTree;
    }

    public void levelOrder() {
        System.out.println();
        for (int i = 1; i <= sizeOfTree; i++) {
            colorPrint(arr[i] + " ", GREEN);
        }
        System.out.println();
    }

    private void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;

        if (index <= 1) return;

        if (heapType.equalsIgnoreCase(MIN_HEAP)) {
            if (arr[index] < arr[parent])
                swap(arr, index, parent);
        } else if (heapType.equalsIgnoreCase(MAX_HEAP)) {
            if (arr[index] > arr[parent])
                swap(arr, index, parent);
        }
        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value, String typeOfHeap) {
        arr[sizeOfTree + 1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, typeOfHeap);
    }

    public void heapifyTopToBottom(int index, String heapType) {
        int left = index * 2, right = index * 2 + 1;
        int swapChild = 0;

        if (sizeOfTree < left) return;

        if (heapType.equalsIgnoreCase(MAX_HEAP)) {
            if (sizeOfTree == left) {
                if (arr[index] < arr[left])
                    swap(arr, index, left);
                return;
            } else {
                swapChild = arr[left] > arr[right] ? left : right;
            }

            if (arr[index] < arr[swapChild])
                swap(arr, index, swapChild);

        } else if (heapType.equalsIgnoreCase(MIN_HEAP)) {
            if (sizeOfTree == right) {
                if (arr[index] < arr[right])
                    swap(arr, index, right);
                return;
            } else {
                swapChild = arr[right] > arr[left] ? right : left;
            }

            if (arr[index] > arr[swapChild])
                swap(arr, index, swapChild);
        }

        heapifyTopToBottom(swapChild, heapType);
    }

    public int extractHead(String heapType) {
        if (isEmpty()) return -1;

        int extractedValue = arr[1];
        arr[1] = arr[sizeOfTree];
        sizeOfTree--;
        heapifyTopToBottom(1, heapType);
        return extractedValue;
    }

    public void deleteHeap() {
        arr = null;
        sizeOfTree = 0;
        colorPrintln("BH has been successfully deleted", RED);
    }
}
