package com.godme.offer.q0202;


class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode left = head, right = head;
        int index = 1;
        while(right.next != null){
            if(++index > k){
                left = left.next;
            }
            right = right.next;
        }
        return left.val;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
