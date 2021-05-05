package com.godme.offer.q06;


class Solution {
    public int[] reversePrint(ListNode head) {
        int size = 0;
        for(ListNode cursor = head; cursor != null; cursor =  cursor.next){
            size += 1;
        }
        int[] res = new int[size];
        for(size -= 1;size > -1; size--, head = head.next){
            res[size] = head.val;
        }
        return res;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
