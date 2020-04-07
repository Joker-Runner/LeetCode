package com.joker;

public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);

        ListNode node = partition(head, 3);
        System.out.println(node);
    }

    public static ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null)
            return head;
        ListNode cursorNode = head, greaterNode = null, greaterPreNode = null;
        ListNode preNode = null;

        while (cursorNode != null) {
            if (cursorNode.val >= x) {
                greaterNode = cursorNode;
                preNode = greaterPreNode;//todo
                break;
            }
            greaterPreNode = cursorNode;
            cursorNode = cursorNode.next;
        }

        while (cursorNode != null) {
            if (cursorNode.val < x) {
                if (preNode == null)
                    break;
                else {
                    preNode.next = cursorNode.next;

                    if (greaterPreNode == null) {
                        cursorNode.next = greaterNode;
                        head = cursorNode;
                        greaterPreNode = cursorNode;
                    } else {
                        greaterPreNode.next = cursorNode;
                        cursorNode.next = greaterNode;
                        greaterPreNode = cursorNode;
                    }
                    cursorNode = preNode.next;
                    continue;
                }
            }
            preNode = cursorNode;
            cursorNode = cursorNode.next;
        }
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
