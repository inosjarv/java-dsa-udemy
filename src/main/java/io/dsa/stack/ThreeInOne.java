package io.dsa.stack;

public class ThreeInOne {
    private final int numberOfStacks = 3;
    private final int stackCapacity;
    private final int[] values;
    private final int[] sizes;

    public ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[numberOfStacks * stackSize];
        sizes = new int[numberOfStacks];
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    public void push(int stackNum, int value) {
        if (isFull(stackNum)) {
            System.out.println("Stack " + stackNum + " is full!!");
        } else {
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
            System.out.println("Inserted Value " + value + " in stack: " + stackNum);
        }

    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("Stack is Empty!!");
            return -1;
        } else {
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return value;
        }
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            System.out.println("Stack is Empty!!");
            return -1;
        } else {
            return values[indexOfTop(stackNum)];
        }
    }
}
