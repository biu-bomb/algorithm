package com.godme.offer.q24;


class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode origin, ListNode reverse){
        if(origin == null) return reverse;
        ListNode residue = origin.next;
        origin.next = reverse;
        return reverseList(residue, origin);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
