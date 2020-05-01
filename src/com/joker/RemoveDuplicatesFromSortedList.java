package com.joker;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
        head = deleteDuplicates(head);

        System.out.println(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.next.val == curNode.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
