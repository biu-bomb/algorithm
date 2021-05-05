package com.godme.leetcode.q1290;


class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        for(ListNode cursor = head; cursor != null; cursor = cursor.next, res *= 2){
            res += cursor.val;
        }
        return res / 2;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
