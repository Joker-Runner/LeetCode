package com.joker;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1, l2;
        l1 = new ListNode(9);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode ln = addTwoNumbers(l1, l2);
        System.out.println(ln);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0), cursorNode = head;
        int carry = 0;

        /**
         * 把这里的 ||carry != 0去掉一下快了好多好多（又试了下也没有太大去区别，待明确）
         */
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            int sum = l1Val + l2Val + carry;
            cursorNode.next = new ListNode(sum % 10);
            cursorNode = cursorNode.next;
            carry = sum / 10;
        }
        if (carry > 0) {
            cursorNode.next = new ListNode(carry);
        }
        return head.next;

        /**
         * 上面有参考优秀答案解决的一个问题，常用！！！
         */
//        ListNode head = null, cursorNode = null;
//        int carry = 0;
//
//        while (l1 != null || l2 != null || carry != 0) {
//            int l1Val = 0;
//            if (l1 != null) {
//                l1Val = l1.val;
//                l1 = l1.next;
//            }
//            int l2Val = 0;
//            if (l2 != null) {
//                l2Val = l2.val;
//                l2 = l2.next;
//            }
//            int sum = l1Val + l2Val + carry;
//            ListNode tempNode = new ListNode(sum % 10);
//            if (head == null) {
//                head = tempNode;
//                cursorNode = tempNode;
//            } else {
//                cursorNode.next = tempNode;
//                cursorNode = cursorNode.next;
//            }
//            carry = sum / 10;
//        }


        /**
         * 才发现不能这样转换，不合算，应该用小学学的加法处理
         */
//        int l1Value = listToNumber(l1);
//        int l2Value = listToNumber(l2);
//
//        int sumValue = l1Value + l2Value;
//
//        if (sumValue == 0)
//            return new ListNode(0);
//
//        ListNode head = null, cursorNode = null;
//        while (sumValue > 0) {
//            ListNode tempNode = new ListNode(sumValue % 10);
//            if (head == null) {
//                head = tempNode;
//                cursorNode = tempNode;
//            } else {
//                cursorNode.next = tempNode;
//                cursorNode = cursorNode.next;
//            }
//            sumValue /= 10;
//        }

        /**
         * 废了老大劲写了倒叙，我以为是显示成数值那样，谁知道直接遍历就行。。。。。。。。。。。
         */
//        ListNode head = null;
//        while (sumValue > 0) {
//            ListNode tempNode = new ListNode(sumValue % 10);
//            tempNode.next = head;
//            head = tempNode;
//            sumValue /= 10;
//        }
//        return head;
    }

    /**
     * 当数组很长时int会溢出，除非用BigInteger其他都可能会溢出，但是BigInteger成本太大
     *
     * @param ln
     * @return
     */
    private static int listToNumber(ListNode ln) {
        int value = 0;
//        do {
//            value = value * 10 + ln.val;
//            ln = ln.next;
//        } while (ln != null);

        int level = 1;
        do {
            value += ln.val * level;
            ln = ln.next;
            level *= 10;
        } while (ln != null);

        return value;
    }


    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
