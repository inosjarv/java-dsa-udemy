package io.dsa.stack;


import io.dsa.linkedlist.SinglyLinkedList;

public class StackLinkedList {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        System.out.println(stack.isEmpty());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        stack.delete();
        System.out.println(stack.isEmpty());
    }

    SinglyLinkedList linkedList;

    public StackLinkedList() {
        linkedList = new SinglyLinkedList();
    }

    public void push(int value) {
        linkedList.insert(value, 0);
        System.out.println("Inserted " + value + " Successfully!");
    }

    public boolean isEmpty() {
        return linkedList.head == null;
    }

    public int pop() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("The Stack is Empty!!");
        }
        else {
            result = linkedList.head.value;
            linkedList.delete(0);
        }
        return result;
    }

    public int peek() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("The Stack is Empty!!");
        } else {
            result = linkedList.head.value;
        }
        return result;
    }

    public void delete() {
        linkedList.head = null;
        System.out.println("Stack is Deleted!!");
    }
}
