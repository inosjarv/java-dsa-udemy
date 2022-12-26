package io.dsa.linkedlist;

public class DoublyLinkedList {

    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insert(10, 0);
        dll.insert(20, 1);
        dll.insert(30, 2);
        dll.insert(40, 3);
        dll.insert(50, 4);
        dll.insert(60, 5);
        dll.insert(70, 6);
        dll.insert(80, 7);

        dll.traverse();

        dll.reverseTraversal();

        dll.search(30);
        dll.search(12);

        dll.delete(3);
        dll.delete(0);
        dll.delete(10);

        dll.traverse();

        dll.deleteDLL();
        dll.traverse();
    }

    public boolean createDoublyLL(int value) {
        DoublyNode node = new DoublyNode(value);
        node.next = node.prev = null;
        head = tail = node;
        size = 1;
        return true;
    }

    public void insert(int value, int location) {
        DoublyNode node = new DoublyNode(value);

        if (head == null) {
            createDoublyLL(value);
            return;
        } else if (location == 0) {
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            DoublyNode tmp = head;
            for (int i = 0; i < location - 1; i++) {
                tmp = tmp.next;
            }
            node.prev = tmp;
            node.next = tmp.next;
            tmp.next = node;
            node.next.prev = node;
        }

        size++;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("LinkedList is Empty!!");
        } else {
            DoublyNode tmp = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tmp.value);

                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tmp = tmp.next;
            }
            System.out.println("\n");
        }
    }

    public void reverseTraversal() {
        if (head == null) {
            System.out.println("LinkedList is Empty!!");
        } else {
            DoublyNode tmp = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tmp.value);

                if (i != size - 1)
                    System.out.print(" <- ");

                tmp = tmp.prev;
            }
            System.out.println("\n");
        }
    }

    public boolean search(int value) {
        if (head == null) {
            System.out.println("LinkedList is Empty!!");
            return false;
        }

        DoublyNode tmp = head;
        for (int i = 0; i < size; i++) {
            if (tmp.value == value) {
                System.out.println("Found at Location: " + i + '\n');
                return true;
            }
            tmp = tmp.next;
        }
        System.out.println("Node not found!!\n");
        return false;
    }

    public void delete(int location) {
        if (head == null) {
            System.out.println("LinkedList is Empty!!");
        } else if (location == 0) {
            if (size == 1) {
                head = tail = null;
                size--;
            } else {
                head = head.next;
                head.prev = null;
                size--;
            }
        } else if (location >= size) {
            DoublyNode tmp = tail.prev;
            if (size == 1) {
                head = tail = null;
                size--;
            } else {
                tmp.next = null;
                tail = tmp;
                size--;
            }
        } else {
            DoublyNode tmp = head;
            for (int i = 0; i < location - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            tmp.next.prev = tmp;
            size--;
        }
    }

    public void deleteDLL() {
        DoublyNode tmp = head;
        for (int i = 0; i < size; i++) {
            tmp.prev = null;
            tmp = tmp.next;
        }
        head = null;
        tail = null;
        System.out.println("LinkedList Deleted!!");
    }
}
