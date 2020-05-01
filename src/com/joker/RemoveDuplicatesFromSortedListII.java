package com.joker;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3,new ListNode(3, new ListNode(4, new ListNode(4,new ListNode(5))))))));
        head = deleteDuplicates(head);

        System.out.println(head);
    }


    public static ListNode deleteDuplicates(ListNode head) {
        //1->2->3->3->3->4->5
        ListNode preHead = new ListNode(0, head);
        ListNode tempNode = preHead;
        ListNode tempDupNode;
        while (tempNode.next != null&& tempNode.next.next!= null){
            if(tempNode.next.val != tempNode.next.next.val){
                tempNode = tempNode.next;
            }else {
                tempDupNode = tempNode.next;
                while (tempDupNode.next != null &&  tempDupNode.next.val == tempDupNode.val){
                    tempDupNode = tempDupNode.next;
                }
                tempNode.next = tempDupNode.next;
            }
        }
        return preHead.next;
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
