package com.godme.leetcode.q206;


class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode origin, ListNode reverseNode){
        if(origin == null){
            return reverseNode;
        }
        ListNode residue = origin.next;
        origin.next = reverseNode;
        return reverse(residue, origin);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
