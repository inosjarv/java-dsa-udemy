package io.dsa.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

class StackNode {
    public StackNode above;
    public int value;
    public StackNode below;

    public StackNode(int value) {
        this.value = value;
    }
}

class Stack {
    public StackNode top;
    public StackNode bottom;
    public int size = 0;
    private final int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void join(StackNode above, StackNode below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public boolean push(int value) {
        if (size >= capacity) return false;
        size++;
        StackNode node = new StackNode(value);
        if (size == 1) bottom = node;
        join(node, top);
        top = node;
        return true;
    }

    public int pop() {
        if (top == null) throw new EmptyStackException();
        int result = top.value;
        top = top.below;
        size--;
        return result;
    }

    public int removeBottom() {
        StackNode b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }
}

public class StackOfPlates {
    public int capacity;
    List<Stack> stacks = new ArrayList<>();

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        stackOfPlates.push(10);
        stackOfPlates.push(20);
        stackOfPlates.push(30);
        stackOfPlates.push(40);
        stackOfPlates.push(50);
        stackOfPlates.push(60);
        stackOfPlates.push(70);

        System.out.println(stackOfPlates.pop());
        System.out.println(stackOfPlates.pop());

    }

    public Stack getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int value) {
        Stack last = getLastStack();
        if (last != null && !last.isFull())
            last.push(value);
        else {
            Stack newStack = new Stack(this.capacity);
            newStack.push(value);
            stacks.add(newStack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int result = last.pop();
        if (last.size == 0) stacks.remove(stacks.size() - 1);
        return result;
    }

    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removeItem;
        if (removeTop) removeItem = stack.pop();
        else removeItem = stack.removeBottom();
        if (stack.size == 0) stacks.remove(index);
        else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removeItem;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }
}
