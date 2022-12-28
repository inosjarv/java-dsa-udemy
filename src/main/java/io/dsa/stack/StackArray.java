package io.dsa.stack;

public class StackArray {
    int[] arr;
    int top;

    public StackArray(int size) {
        this.arr = new int[size];
        top = -1;
        System.out.println("Stack is Created with Size of: " + size);
    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray(5);
        System.out.println("Is Stack Empty? : " + stackArray.isEmpty());
        stackArray.push(10);
        stackArray.push(20);
        stackArray.push(30);
        stackArray.push(40);
        stackArray.push(50);

        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());
        System.out.println(stackArray.peek());
        System.out.println(stackArray.pop());
        System.out.println(stackArray.peek());

        stackArray.delete();
        System.out.println(stackArray.peek());
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("The Stack is Full!!");
        } else {
            arr[top + 1] = value;
            top++;
            System.out.println("Value Inserted!");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("The Stack is Empty");
            return -1;
        } else {
            int topStack = arr[top];
            top--;
            return topStack;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The Stack is Empty");
            return -1;
        } else {
            return arr[top - 1];
        }
    }

    public void delete() {
        arr = null;
        top = -1;
        System.out.println("The Stack is Deleted");
    }
}
