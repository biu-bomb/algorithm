package com.godme.offer.q18;


class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode cursor = head;
        while (cursor.next.val != val){
            cursor = cursor.next;
        }
        cursor.next = cursor.next.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
