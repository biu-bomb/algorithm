package com.godme.offer.q0207;


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cursorA = headA, cursorB = headB;
        while(cursorA != cursorB){
            cursorA = cursorA == null ? headB : cursorA.next;
            cursorB = cursorB == null ? headA : cursorB.next;
        }
        return cursorA;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

