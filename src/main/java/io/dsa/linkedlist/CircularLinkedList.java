package io.dsa.linkedlist;

public class CircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList csll = new CircularLinkedList();

        csll.insert(10, 0);
        csll.insert(20, 1);
        csll.insert(30, 2);
        csll.insert(40, 3);
        csll.insert(50, 5);
        csll.insert(60, 6);
        csll.insert(70, 7);

        csll.traverse();

        csll.delete(0);
        csll.delete(3);
        csll.delete(10);

        csll.traverse();

        csll.deleteCSLL();

        csll.traverse();

        csll.search(20);
        csll.search(45634);
    }


    public Node head;
    public Node tail;
    public int size;

    public Node createCircularLL(int value) {
        Node node = new Node(value);
        node.next = node;
        head = tail = node;
        size = 1;
        return head;
    }

    public void insert(int value, int location) {
        Node node = new Node(value);

        if (head == null) {
            createCircularLL(value);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = node;
        } else if (location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            Node tmp = head;
            for (int i = 0; i < location - 1; i++) {
                tmp = tmp.next;

            }
            node.next = tmp.next;
            tmp.next = node;
        }
        size++;
    }

    public void traverse() {
        if (head == null) System.out.print("Linked List is Empty!!");
        else {
            Node tmp = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tmp.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tmp = tmp.next;
            }
        }
        System.out.println("\n");
    }

    public boolean search(int value) {
        if (head == null) {
            System.out.println("LinkedList is Empty!!");
            return false;
        }

        Node tmp = head;
        for (int i = 0; i < size; i++) {
            if (tmp.value == value) {
                System.out.println("Found at Location: " + i);
                return true;
            }
            tmp = tmp.next;
        }
        System.out.println("Node not found!!");
        return false;
    }

    public void delete(int location) {
        if (head == null) {
            System.out.println("LinkedList is Empty!!");
            return;
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                tail = null;
                head.next = null;
                head = null;
            }
        } else if (location >= size) {
            Node tmp = head;
            for (int i = 0; i < size - 1; i++) {
                tmp = tmp.next;
            }
            if (tmp == head) {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            tmp.next = head;
            tail = tmp;
            size--;
        } else {
            Node tmp = head;
            for (int i = 0; i < location - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            size--;
        }
    }

    public void deleteCSLL() {
        if (head == null) {
            System.out.println("LinkedList is Empty!");
        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("LinkedList Deleted!!");
        }
    }
}
