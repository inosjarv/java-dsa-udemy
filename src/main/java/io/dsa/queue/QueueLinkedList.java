package io.dsa.queue;

import io.dsa.linkedlist.SinglyLinkedList;

public class QueueLinkedList {
    SinglyLinkedList linkedList;

    public QueueLinkedList() {
        linkedList = new SinglyLinkedList();
        System.out.println("Queue is Created Successfully");
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        System.out.println(queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.isEmpty());

        System.out.println(queue.peek());
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
            queue.delete();
        }

        System.out.println(queue.isEmpty());
    }

    public boolean isEmpty() {
        return linkedList.head == null;
    }

    public void enqueue(int value) {
        linkedList.insert(value, linkedList.size);
        System.out.println("Value " + value + " inserted successfully!!");
    }

    public int dequeue() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            result = linkedList.head.value;
            linkedList.delete(0);
        }
        return result;
    }

    public int peek() {
        int result = -1;
        if (isEmpty())
            System.out.println("Queue is Empty!!");
        else
            result = linkedList.head.value;

        return result;
    }

    public void delete() {
        linkedList.head = linkedList.tail = null;
        System.out.println("Queue is Deleted!!");
    }
}
