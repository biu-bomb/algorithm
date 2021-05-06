package com.godme.leetcode.q876;


class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        for(ListNode fast = head; fast != null && fast.next != null;fast = fast.next.next){
            mid = mid.next;
        }
        return mid;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
