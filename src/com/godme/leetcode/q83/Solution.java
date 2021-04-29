package com.godme.leetcode.q83;


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode residue = head;
        while (residue != null && residue.val == head.val){
            residue = residue.next;
        }
        head.next = deleteDuplicates(residue);
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
