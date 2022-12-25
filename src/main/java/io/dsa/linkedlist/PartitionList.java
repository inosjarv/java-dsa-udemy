package io.dsa.linkedlist;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode left = new ListNode(), right = new ListNode();
        ListNode leftTail = left, rightTail = right;

        while (head != null) {
            if (head.val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }

        leftTail.next = right.next;
        rightTail.next = null;

        return left.next;
    }
}