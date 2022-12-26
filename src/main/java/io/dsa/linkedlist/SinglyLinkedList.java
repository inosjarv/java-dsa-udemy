package io.dsa.linkedlist;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insert(10, 1);
        sll.insert(20, 2);
        sll.insert(30, 3);
        sll.insert(40, 4);
        sll.insert(50, 5);
        sll.insert(60, 6);
        sll.insert(70, 7);
        sll.insert(80, 8);
        sll.insert(90, 9);
        sll.insert(100, 10);

        sll.traverse();

        System.out.println(sll.search(40));
        System.out.println(sll.search(3455));

        sll.delete(0);
        sll.delete(4);
        sll.delete(10);
        sll.traverse();

        sll.deleteLinkedList();
        sll.traverse();
    }

    public Node createSinglyLinkedList(int value) {
        Node node = new Node(value);
        node.next = null;
        head = node;
        tail = node;
        size = 1;

        return head;
    }

    public void insert(int value, int location) {
        Node node = new Node(value);

        if (head == null) {
            createSinglyLinkedList(value);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node temp = head;
            int idx = 0;

            while (idx < location - 1) {
                temp = temp.next;
                idx++;
            }

            Node nextNode = temp.next;
            temp.next = node;
            node.next = nextNode;
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
        } else if (location == 0) {
            head = head.next;
            size--;

            if (size == 0) tail = null;
        } else if (location >= size - 1) {
            Node tmp = head;
            for (int i = 0; i < size - 1; i++) {
                tmp = tmp.next;
            }

            if (tmp == head) {
                tail = head = null;
                size--;
                return;
            }
            tmp.next = null;
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

    public void deleteLinkedList() {
        head = tail = null;
        System.out.println("LinkedList Deleted Successfully!");
    }
}
