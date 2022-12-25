package io.dsa.queue;

public class QueueArray {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;

    public QueueArray(int size) {
        arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("Created Queue with size: " + size);
    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);
        System.out.println(queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);


        System.out.println("Dequeued Element is: " + queue.dequeue());
        System.out.println("Peeked Element is " + queue.peek());
        System.out.println("Peeked Element is " + queue.peek());
        System.out.println("Dequeued Element is: " + queue.dequeue());
        queue.deleteQueue();
        System.out.println("Peeked Element is " + queue.peek());
        System.out.println("Dequeued Element is: " + queue.dequeue());
        System.out.println("Dequeued Element is: " + queue.dequeue());

    }

    public boolean isFull() {
        return topOfQueue == arr.length - 1;
    }

    public boolean isEmpty() {
        return beginningOfQueue == -1 || beginningOfQueue == arr.length;
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = val;
            System.out.println("Value" + val + " is inserted in Queue");

        } else {
            topOfQueue++;
            arr[topOfQueue] = val;
            System.out.println("Value" + val + " is inserted in Queue");
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            int result = arr[beginningOfQueue];
            beginningOfQueue++;
            if (beginningOfQueue > topOfQueue) {
                beginningOfQueue = -1;
                topOfQueue = -1;
            }
            return result;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } else {
            return arr[beginningOfQueue];
        }
    }

    public void deleteQueue() {
        arr = null;
        topOfQueue = -1;
        beginningOfQueue = -1;
        System.out.println("Queue is Successfully Deleted!!");
    }
}
