package com.godme.offer.q0204;


class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1), largeHead = new ListNode(0), smallCursor = smallHead, largeCursor = largeHead;

        while (head != null) {
            if (head.val < x) {
                smallCursor.next = head;
                smallCursor = smallCursor.next;
            } else {
                largeCursor.next = head;
                largeCursor = largeCursor.next;
            }
            head = head.next;
        }
        largeCursor.next = null;
        smallCursor.next = largeHead.next;
        return smallHead.next;
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
