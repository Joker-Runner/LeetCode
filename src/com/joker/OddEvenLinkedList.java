package com.joker;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tempHead = head;
        for (int i = 1; i < 7; i++) {
            tempHead.next = new ListNode(i + 1);
            ;
            tempHead = tempHead.next;
        }

        ListNode listNode = oddEvenList(head);
        System.out.println(listNode.val);
    }

    public static ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode head2 = head.next;
        ListNode fasterNode = head;
        ListNode slowerNode = head2;

        while (fasterNode.next != null && fasterNode.next.next != null) {
            fasterNode.next = fasterNode.next.next;
            slowerNode.next = fasterNode.next.next;
            fasterNode = fasterNode.next;
            slowerNode = slowerNode.next;
        }
        fasterNode.next = head2;
        return head;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


