package io.dsa.stack;

public class MinStack {
    Node top;
    Node min;

    public MinStack() {
        top = null;
        min = null;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        System.out.println(minStack.pop());
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

    public int getMin() {
        return this.min.value;
    }

    public void push(int value) {
        if (min == null) {
            min = new Node(value, min);
        } else if (min.value < value) {
            min = new Node(min.value, min);
        } else {
            min = new Node(value, min);
        }
        top = new Node(value, top);
    }

    public int pop() {
        min = min.next;
        int result = top.value;
        top = top.next;
        return result;
    }

    public int top() {
        return this.top.value;
    }

    private class Node {
        private final int value;
        private final Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
