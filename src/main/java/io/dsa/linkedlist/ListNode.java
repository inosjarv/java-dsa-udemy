package io.dsa.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
