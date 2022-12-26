package io.dsa.linkedlist;

public class CircularDoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
        cdll.insert(10, 0);
        cdll.insert(20, 1);
        cdll.insert(30, 2);
        cdll.insert(40, 3);
        cdll.insert(50, 4);
        cdll.insert(60, 5);
        cdll.insert(70, 6);
        cdll.insert(80, 7);

        cdll.traverse();
        cdll.reverseTraversal();

        cdll.search(30);
        cdll.search(84573);

        cdll.delete(0);
        cdll.delete(4);
        cdll.delete(11);

        cdll.traverse();

        cdll.deleteCDLL();
        cdll.traverse();
    }

    public DoublyNode createCircularDLL(int value) {
        DoublyNode node = new DoublyNode(value);
        head = node;
        tail = node;
        node.next = node;
        node.prev = node;
        size = 1;
        return head;
    }

    public void insert(int value, int location) {
        DoublyNode node = new DoublyNode(value);

        if (head == null) {
            createCircularDLL(value);
            return;
        } else if (location == 0) {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            head = node;
            tail.next = node;
        } else if (location >= size) {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
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
            System.out.print("LinkedList is Empty!!");
        } else if (location == 0) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
            size--;
        } else if (location >= size) {
            if (size == 1) {
                head.prev = null;
                head.next = null;
                head = tail = null;
                size--;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
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

    public void deleteCDLL() {
        DoublyNode tempNode = head;
        for (int i = 0; i < size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("The CDLL has been deleted!");
    }
}
