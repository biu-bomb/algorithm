package com.godme.leetcode.q92;



class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        head = new ListNode(-1, head);
        ListNode cursorNode = head;
        int cursorIndex = 0;
        for (; cursorIndex < left; cursorIndex++) {
            cursorNode = cursorNode.next;
        }
        ListNode insertNode = cursorNode;
        cursorNode = insertNode.next;
        for (; cursorIndex < right; cursorIndex++){
            insertAfter(insertNode, popNext(cursorNode));
        }
        return head.next;
    }

    public ListNode popNext(ListNode node){
        ListNode next = node.next;
        node.next = next.next;
        return next;
    }

    public void insertAfter(ListNode prev, ListNode node){
        ListNode next = prev.next;
        prev.next = node;
        node.next = next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
